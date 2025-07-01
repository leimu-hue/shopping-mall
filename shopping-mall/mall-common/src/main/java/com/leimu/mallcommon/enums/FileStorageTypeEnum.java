package com.leimu.mallcommon.enums;

import lombok.Getter;

@Getter
public enum FileStorageTypeEnum {

    ALI_YUN_OSS("aliYun"),    // 阿里云OSS

    MINIO("minio"),         // MinIO

    TENCENT_OSS("tencentYun"),   // 腾讯云OSS

    LOCAL("local"),          // 本地存储
    ;

    FileStorageTypeEnum(String name) {
        this.name = name;
    }

    private final String name;

}
