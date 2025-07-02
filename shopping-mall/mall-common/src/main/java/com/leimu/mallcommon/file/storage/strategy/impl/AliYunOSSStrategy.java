package com.leimu.mallcommon.file.storage.strategy.impl;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.*;
import com.leimu.mallcommon.enums.FileStorageTypeEnum;
import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.leimu.mallcommon.file.storage.show.UploadResult;
import com.leimu.mallcommon.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service(value = "aliYun")
public class AliYunOSSStrategy extends AbstractFileUploadStrategy {

    private volatile OSS ossClient;

    private static final Object lock = new Object();

    @Override
    public String getFileUrl(String filePath, FileStorageConfig config) {
        return config.getEndpoint() + "/" + config.getBucketName() + "/" + filePath;
    }

    @Override
    public FileStorageTypeEnum getStorageType() {
        return FileStorageTypeEnum.ALI_YUN_OSS;
    }

    @Override
    protected UploadResult doUpload(InputStream inputStream, String fileName, String directory, FileStorageConfig config) {
        try {
            createOssClient(config);
            boolean b = ossClient.doesBucketExist(config.getBucketName());
            if (!b) {
                ossClient.createBucket(config.getBucketName());
            }
            String filePath = FileUtil.delFirstFilePath(FileUtil.concatFile(directory, fileName));
            // 设置文件为公共读
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setObjectAcl(CannedAccessControlList.PublicRead);
            ossClient.putObject(config.getBucketName(), filePath, inputStream, objectMetadata);
            return new UploadResult(true, "https://" + config.getBucketName() + "." + config.getEndpoint().replace("https://", "")
                    + "/" + filePath, fileName);
        } catch (OSSException ossException) {
            return new UploadResult(false, ossException.getErrorMessage());
        } catch (ClientException clientException) {
            return new UploadResult(false, "network confused");
        }
    }

    @Override
    public boolean delete(String filePath, FileStorageConfig config) {
        try {
            createOssClient(config);
            // 通过filePath，获取一个插槽
            filePath = filePath.replace("https://", "");
            String bucketName = filePath.substring(0, filePath.indexOf("."));
            if (StringUtils.isBlank(bucketName)) {
                bucketName = config.getBucketName();
            }
            ossClient.deleteObject(bucketName, FileUtil.delFirstFilePath(FileUtil.readFilePathByOSSFile(filePath)));
            return true;
        } catch (OSSException | ClientException e) {
            return false;
        }
    }

    @Override
    public void shutdown() {
        if (null != ossClient) {
            ossClient.shutdown();
        }
    }

    private void createOssClient(FileStorageConfig config) {
        if (null == ossClient) {
            synchronized (lock) {
                if (null == ossClient) {
                    DefaultCredentialProvider defaultCredentialProvider = CredentialsProviderFactory.newDefaultCredentialProvider(config.getAccessKeyId(), config.getAccessKeySecret());

                    ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
                    clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
                    OSSClientBuilder.OSSClientBuilderImpl clientBuilder = OSSClientBuilder.create()
                            .endpoint(config.getEndpoint())
                            .credentialsProvider(defaultCredentialProvider);
                    if (!StringUtils.isBlank(config.getRegion())) {
                        clientBuilder.region(config.getRegion());
                    }
                    ossClient = clientBuilder.build();
                }
            }
        }
    }
}
