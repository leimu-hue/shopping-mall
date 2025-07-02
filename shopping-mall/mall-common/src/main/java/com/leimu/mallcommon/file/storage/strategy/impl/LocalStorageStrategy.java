package com.leimu.mallcommon.file.storage.strategy.impl;

import com.leimu.mallcommon.enums.FileStorageTypeEnum;
import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.leimu.mallcommon.file.storage.exceptions.FileUploadException;
import com.leimu.mallcommon.file.storage.show.UploadResult;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Service(value = "local")
public class LocalStorageStrategy extends AbstractFileUploadStrategy {


    @Override
    public void init(FileStorageConfig config) {
        if (!new File(config.getLocalPath()).exists()) {
            new File(config.getLocalPath()).mkdirs();
        }
    }

    @Override
    protected UploadResult doUpload(InputStream inputStream, String fileName, String directory, FileStorageConfig config) {
        try {
            File targetFile = getFile(fileName, directory, config);

            try (inputStream; FileOutputStream fos = new FileOutputStream(targetFile)) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            String fileUrl = "file://" + targetFile.getAbsolutePath();
            return new UploadResult(true, fileUrl, fileName);
        } catch (Exception e) {
            return new UploadResult(false, "本地存储上传失败: " + e.getMessage());
        }
    }

    @Override
    public boolean delete(String filePath, FileStorageConfig config) {
        try {
            File file = new File(config.getLocalPath(), filePath);
            if (file.exists()) return file.delete();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getFileUrl(String filePath, FileStorageConfig config) {
        return "file://" + new File(config.getLocalPath(), filePath).getAbsolutePath();
    }

    @Override
    public FileStorageTypeEnum getStorageType() {
        return FileStorageTypeEnum.LOCAL;
    }

    private static File getFile(String fileName, String directory, FileStorageConfig config) {
        String localPath = config.getLocalPath();
        if (localPath == null || localPath.trim().isEmpty()) throw new FileUploadException("本地存储路径未配置");

        String filePath = directory + "/" + fileName;
        File targetDir = new File(localPath);
        if (!targetDir.exists())
            targetDir.mkdirs();

        File targetFile = new File(targetDir, filePath);
        if (!targetFile.getParentFile().exists())
            targetFile.getParentFile().mkdirs();
        return targetFile;
    }

}
