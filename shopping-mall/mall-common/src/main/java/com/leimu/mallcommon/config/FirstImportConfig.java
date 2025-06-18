package com.leimu.mallcommon.config;

import com.leimu.mallcommon.utils.RedisUtil;
import org.redisson.spring.starter.RedissonAutoConfigurationV2;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RedisConfig.class, Swagger3Config.class, SecurityConfig.class, RedisUtil.class})
@AutoConfiguration(
        before = {RedissonAutoConfigurationV2.class}
)
public class FirstImportConfig {
}
