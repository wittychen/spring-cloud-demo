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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon 服务调用
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-17 19:59
 */
@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${serivce-provider.host}")
    private String serviceProviderHost;

    @Value("${serivce-provider.port}")
    private Integer serviceProviderPort;

    @Value("${serivce-provider.name}")
    private String serviceProviderName;

    @GetMapping("/ip-port")
    public UserVO ipPort() {
        return restTemplate
            .getForObject("http://" + serviceProviderHost + ":" + serviceProviderPort + "/user/1", UserVO.class);
    }

    @GetMapping("/service-name")
    public UserVO serviceName() {
        return restTemplate.getForObject("http://" + serviceProviderName + "/user/1", UserVO.class);
    }
}
