package com.leimu.mallcommon.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("接口文档详解")
                        .description("Swagger 3.0 + SpringBoot 3.x 生成")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("接口文档详解"));
    }

    @Bean
    public GroupedOpenApi allOpenApi() {
        return GroupedOpenApi.builder()
                .group("mall-product")
                .packagesToScan("com.leimu.mallproduct.controller")
                .build();
    }

}
