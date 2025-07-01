package com.leimu.mallcommon.file.storage.config;

import com.leimu.mallcommon.enums.FileStorageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileStorageConfig {

    private String type;

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String localPath;

    public FileStorageConfig(String type) {
        this.type = type;
        this.endpoint = "";
        this.accessKeyId = "";
        this.accessKeySecret = "";
        this.bucketName = "";
        this.localPath = "";
    }

    public String verify() {
        if (Objects.equals(this.type, FileStorageTypeEnum.LOCAL.getName())) {
            if (StringUtils.isBlank(this.localPath)) {
                return "本地上传, 上传地址不可为空";
            }
        } else {
            if (StringUtils.isBlank(this.accessKeyId) || StringUtils.isBlank(this.accessKeySecret)) {
                return "云端上传, 上传密钥不可为空";
            }
            if (StringUtils.isBlank(this.bucketName)) {
                return "云端上传, 使用的槽不可为空";
            }
            if (StringUtils.isBlank(this.endpoint)) {
                return "云端上传, 上传地址不可为空";
            }
        }
        return "";
    }

}
