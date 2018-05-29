/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.ribbon.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.wittychen.cloudmall.ribbon.vo.UserVO;

import org.springframework.web.client.RestTemplate;

/**
 * UserHystrixCommand
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-18 20:13
 */
public class UserHystrixCommand extends HystrixCommand<UserVO> {

    private String serviceProviderName;

    private RestTemplate restTemplate;

    public UserHystrixCommand(String serviceProviderName, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey("cloud-mall-ribbon"), 100);
        this.serviceProviderName = serviceProviderName;
        this.restTemplate = restTemplate;
    }

    @Override
    protected UserVO run() {
        UserVO userVO = restTemplate.getForObject("http://" + serviceProviderName + "/user/hys/1", UserVO.class);
        return userVO;
    }

    @Override
    protected UserVO getFallback() {
        return new UserVO();
    }
}
