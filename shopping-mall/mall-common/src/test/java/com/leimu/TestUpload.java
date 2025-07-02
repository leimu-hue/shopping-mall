package com.leimu;

import com.leimu.mallcommon.file.storage.config.FileStorageConfig;
import com.leimu.mallcommon.file.storage.strategy.impl.AliYunOSSStrategy;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TestUpload {

    @Test
    public void updateFile() throws IOException {
        File file = new File("C:\\Users\\user\\Pictures\\Saved Pictures\\1.jpg");

        FileStorageConfig storageConfig = new FileStorageConfig();
        storageConfig.setEndpoint("https://oss-cn-shanghai.aliyuncs.com/");
        storageConfig.setBucketName("");
        storageConfig.setAccessKeyId("");
        storageConfig.setAccessKeySecret("");

        AliYunOSSStrategy aliYunOSSStrategy = new AliYunOSSStrategy();
//        UploadResult upload = aliYunOSSStrategy.upload(file, "images/upload", storageConfig);
//        System.out.println(upload);
        String fileUrl = "https://leimu-hue.oss-cn-shanghai.aliyuncs.com/images/upload/d5c6d157d2024ff08f2d69e68b8251a0.jpg";
        aliYunOSSStrategy.delete(fileUrl, storageConfig);

        aliYunOSSStrategy.shutdown();
    }

}
