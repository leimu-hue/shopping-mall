package com.leimu.mallgateway.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Getter
public class SystemPropertyConfig {

    @Value("${value.test:}")
    private String valueTest;

}
