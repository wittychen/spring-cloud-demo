package com.wittychen.cloudmall.user;

import com.wittychen.cloudmall.user.manager.stream.UserMessage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@MapperScan("com.wittychen.cloudmall.user.dal")
@EnableBinding(UserMessage.class) // 激活 Stream Binding 到 UserMessage
public class CloudMallUserStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMallUserStarterApplication.class, args);
    }
}
