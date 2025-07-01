package com.leimu.mallcommon.file.storage.strategy;

import com.leimu.mallcommon.enums.FileStorageTypeEnum;
import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.leimu.mallcommon.file.storage.show.UploadResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileUploadStrategy {

    UploadResult upload(File file, String directory, FileStorageConfig config) throws IOException;

    UploadResult upload(MultipartFile file, String directory, FileStorageConfig config) throws IOException;

    boolean delete(String filePath, FileStorageConfig config);

    String getFileUrl(String filePath, FileStorageConfig config);

    FileStorageTypeEnum getStorageType();
}
