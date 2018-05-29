package com.wittychen.cloudmall.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudMallConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMallConsulApplication.class, args);
    }
}
