package com.leimu.mallcommon.file.storage.strategy.impl;

import com.leimu.mallcommon.enums.FileStorageTypeEnum;
import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.leimu.mallcommon.file.storage.show.UploadResult;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service(value = "aliYun")
public class AliYunOSSStrategy extends AbstractFileUploadStrategy {

    @Override
    public boolean delete(String filePath, FileStorageConfig config) {
        return false;
    }

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
        return null;
    }

}
