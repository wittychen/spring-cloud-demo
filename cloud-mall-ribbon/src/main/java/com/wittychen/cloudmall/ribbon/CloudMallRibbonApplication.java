package com.wittychen.cloudmall.ribbon;

import com.netflix.loadbalancer.IRule;
import com.wittychen.cloudmall.ribbon.rule.MyLastRule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 可以多个ribbon服务定义
@RibbonClients({ @RibbonClient(name = "cloud-mall-user-service") })
//@RibbonClient("cloud-mall-user-service") // 单个服务
@EnableDiscoveryClient
@EnableCircuitBreaker  // 使用服务短路
public class CloudMallRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMallRibbonApplication.class, args);
    }

    // 在eureka上注册服务才能使用这个注解
    @LoadBalanced // 负载均衡算法
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myLastRule() {
        return new MyLastRule();
    }

}
