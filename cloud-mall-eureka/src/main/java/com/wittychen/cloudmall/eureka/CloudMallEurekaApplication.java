package com.wittychen.cloudmall.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudMallEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMallEurekaApplication.class, args);
    }
}
