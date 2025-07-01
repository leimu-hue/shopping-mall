package com.leimu.mallcommon.file.storage;

import com.leimu.mallcommon.enums.FileStorageTypeEnum;
import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.leimu.mallcommon.file.storage.show.UploadResult;
import com.leimu.mallcommon.file.storage.strategy.FileUploadStrategy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@Service
public class FileUploadManager {

    private final Map<String, FileUploadStrategy> fileUploadStrategyMap;

    public FileUploadManager(Map<String, FileUploadStrategy> fileUploadStrategyMap) {
        this.fileUploadStrategyMap = fileUploadStrategyMap;
    }

    public UploadResult uploadFile(FileStorageTypeEnum fileStorageTypeEnum, File file, String directory, FileStorageConfig config) {
        if (checkUpdateStorage(fileStorageTypeEnum)) {
            return new UploadResult(false, "不支持当前文件操作方式");
        }
        try {
            return fileUploadStrategyMap.get(fileStorageTypeEnum.getName()).upload(file, directory, config);
        } catch (Exception e) {
            return new UploadResult(false, "上传失败, 稍后重试");
        }
    }

    public UploadResult uploadFile(FileStorageTypeEnum fileStorageTypeEnum, MultipartFile file, String directory, FileStorageConfig config) {
        if (checkUpdateStorage(fileStorageTypeEnum)) {
            return new UploadResult(false, "不支持当前文件操作方式");
        }
        try {
            return fileUploadStrategyMap.get(fileStorageTypeEnum.getName()).upload(file, directory, config);
        } catch (Exception e) {
            return new UploadResult(false, "上传失败, 稍后重试");
        }
    }

    public boolean deleteFile(FileStorageTypeEnum fileStorageTypeEnum, String filePath, FileStorageConfig config) {
        if (checkUpdateStorage(fileStorageTypeEnum)) {
            return false;
        }
        try {
            return fileUploadStrategyMap.get(fileStorageTypeEnum.getName()).delete(filePath, config);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkUpdateStorage(FileStorageTypeEnum fileStorageTypeEnum) {
        return !fileUploadStrategyMap.containsKey(fileStorageTypeEnum.getName());
    }

}
