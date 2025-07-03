package com.ruoyi.service;

import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.ruoyi.common.core.domain.AjaxResult;

public interface FileUploadService {

    FileStorageConfig getFileStorageConfig();

    void setFileStorageConfig(FileStorageConfig fileStorageConfig);

    AjaxResult generatePresignedUrl(String fileName, String fileType);

}
