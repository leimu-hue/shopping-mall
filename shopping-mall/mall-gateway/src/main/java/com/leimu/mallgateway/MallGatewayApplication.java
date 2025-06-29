package com.leimu.mallgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import reactor.core.publisher.Hooks;

@SpringBootApplication
@EnableDiscoveryClient
public class MallGatewayApplication {

    public static void main(String[] args) {
        // 开启上下文，允许MCD可以在线程中传输
        Hooks.enableAutomaticContextPropagation();
        SpringApplication.run(MallGatewayApplication.class, args);
    }

}
