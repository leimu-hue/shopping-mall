package com.ruoyi.service.impl;

import com.leimu.mallcommon.constant.ConstantRedis;
import com.leimu.mallcommon.enums.FileStorageTypeEnum;
import com.leimu.mallcommon.file.storage.FileUploadManager;
import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    private final RedisCache redisCache;

    private final FileUploadManager fileUploadManager;

    public FileUploadServiceImpl(RedisCache redisCache, FileUploadManager fileUploadManager) {
        this.redisCache = redisCache;
        this.fileUploadManager = fileUploadManager;
    }

    @Override
    public FileStorageConfig getFileStorageConfig() {
        FileStorageConfig cacheObject = redisCache.getCacheObject(ConstantRedis.SYSTEM_OSS_CONFIG);
        if (Objects.isNull(cacheObject)) {
            cacheObject = new FileStorageConfig(FileStorageTypeEnum.LOCAL.getName());
        }
        return cacheObject;
    }

    @Override
    public void setFileStorageConfig(FileStorageConfig fileStorageConfig) {
        FileStorageConfig cacheConfig = getFileStorageConfig();
        if (Objects.equals(cacheConfig, fileStorageConfig)) {
//            fileUploadManager
        }
        redisCache.setCacheObject(ConstantRedis.SYSTEM_OSS_CONFIG, fileStorageConfig);
    }

    @Override
    public AjaxResult generatePresignedUrl(String fileName, String fileType) {
        FileStorageConfig fileStorageConfig = getFileStorageConfig();
        FileStorageTypeEnum fileStorageTypeEnum = FileStorageTypeEnum.getFileStorageTypeEnum(fileStorageConfig.getType());
        if (Objects.isNull(fileStorageTypeEnum)) {
            fileStorageTypeEnum = FileStorageTypeEnum.LOCAL;
        }
        try {
            String url = fileUploadManager.generatePresinedUrl(fileStorageTypeEnum, fileName, fileType, fileStorageConfig);
            return AjaxResult.success("success", url);
        } catch (Exception e) {
            log.error("生成直传链接出错, errorMsg:{}", e.getMessage());
            return AjaxResult.error("生成失败, 请稍后重试");
        }
    }
}
