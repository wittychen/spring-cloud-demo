/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.ribbon.controller;

import com.wittychen.cloudmall.ribbon.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon自定义Rule
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-18 13:41
 */
@RestController
public class RibbonCustomController {

    @Value("${serivce-provider.name}")
    private String serviceProviderName;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/custom")
    public UserVO custom() throws Exception {
        // 选择指定serviceId的实例
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceProviderName);
        UserVO userVO = loadBalancerClient.execute(serviceProviderName, serviceInstance, instance -> {
            String host = instance.getHost();
            int port = instance.getPort();
            String url = "http://" + host + ":" + port + "/user/1";
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, UserVO.class);
        });
        return userVO;
    }
}
