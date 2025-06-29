package com.leimu.mallcommon.config;

import org.redisson.spring.starter.RedissonAutoConfigurationV2;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RedisConfig.class, Swagger3Config.class, SecurityConfig.class, MybatisPlusConfig.class})
@AutoConfiguration(
        before = {RedissonAutoConfigurationV2.class}
)
public class FirstImportConfig {
}
