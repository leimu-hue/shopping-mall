package com.leimu.mallcommon.file.storage.strategy.impl;

import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.leimu.mallcommon.file.storage.show.UploadResult;
import com.leimu.mallcommon.file.storage.strategy.FileUploadStrategy;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractFileUploadStrategy implements FileUploadStrategy {

    /**
     * 生成唯一文件名
     * @param originalFileName 原始文件名
     * @return 生成的唯一文件名
     */
    protected String generateFileName(String originalFileName) {
        String extension = "";
        if (originalFileName.contains(".")) {
            extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }
        return UUID.randomUUID().toString().replace("-", "") + extension;
    }

    @Override
    public UploadResult upload(File file, String directory, FileStorageConfig config) throws IOException {
        if (file == null || !file.exists() || !file.isFile()) {
            return new UploadResult(false, "文件不存在");
        }
        return doUpload(new BufferedInputStream(new FileInputStream(file)), generateFileName(file.getName()), directory, config);
    }

    @Override
    public UploadResult upload(MultipartFile file, String directory, FileStorageConfig config) throws IOException {
        if (Objects.isNull(file)) {
            return new UploadResult(false, "文件不存在");
        }
        return doUpload(file.getInputStream(), generateFileName(file.getName()), directory, config);
    }

    protected abstract UploadResult doUpload(InputStream inputStream, String fileName, String directory, FileStorageConfig config);

}
