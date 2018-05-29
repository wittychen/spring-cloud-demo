package com.wittychen.cloudmall.web;

import com.wittychen.cloudmall.user.api.service.UserClientService;
import com.wittychen.cloudmall.web.client.UserClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker // 使用服务短路
@EnableFeignClients(clients = {UserClientService.class,UserClient.class}) // 申明 UserService 接口作为 Feign Client 调用
//@EnableFeignClients(basePackages = { "com.wittychen.cloudmall.web.client"})
public class CloudMallWebApplication {

    private static final Logger LOG = LoggerFactory.getLogger(CloudMallWebApplication.class);

    //    @Autowired
    //    private ContextRefresher contextRefresher;

    public static void main(String[] args) {
        SpringApplication.run(CloudMallWebApplication.class, args);
    }

    /**
     * 从配置中心拉取配置
     */
    //    @Scheduled(fixedRate = 10000)
    //    public void configUpdate() {
    //        Set<String> keys = contextRefresher.refresh();
    //        if (!keys.isEmpty()) {
    //            LOG.info("本次更新的配置项: " + keys);
    //        }
    //    }
}
