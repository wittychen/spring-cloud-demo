package com.wittychen.cloudmall.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinServer
@EnableDiscoveryClient
@EnableZipkinStreamServer
public class CloudMallSleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMallSleuthApplication.class, args);
    }
}
