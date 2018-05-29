/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.ribbon.controller;

import com.wittychen.cloudmall.ribbon.vo.UserVO;
import com.wittychen.cloudmall.ribbon.hystrix.UserHystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Hytrix
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-18 20:09
 */
@RestController
public class RibbonHytrixController {

    @Value("${serivce-provider.name}")
    private String serviceProviderName;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hystrix")
    public UserVO hystrix() {
        return new UserHystrixCommand(serviceProviderName,restTemplate).execute();
    }

}
