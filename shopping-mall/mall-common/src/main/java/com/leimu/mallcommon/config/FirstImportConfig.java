package com.leimu.mallcommon.config;

import com.leimu.mallcommon.file.storage.FileUploadManager;
import com.leimu.mallcommon.file.storage.strategy.impl.AliYunOSSStrategy;
import com.leimu.mallcommon.file.storage.strategy.impl.LocalStorageStrategy;
import org.redisson.spring.starter.RedissonAutoConfigurationV2;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RedisConfig.class, Swagger3Config.class, SecurityConfig.class, MybatisPlusConfig.class
        , FileUploadManager.class, LocalStorageStrategy.class, AliYunOSSStrategy.class})
@AutoConfiguration(
        before = {RedissonAutoConfigurationV2.class}
)
public class FirstImportConfig {
}
