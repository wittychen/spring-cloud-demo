/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.user.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wittychen.cloudmall.user.api.bo.UserBO;
import com.wittychen.cloudmall.user.api.service.UserService;
import com.wittychen.cloudmall.user.manager.UserManger;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-14 18:06
 */

@RestController
@RequestMapping("/user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManger userManger;

    @GetMapping(value = "/{id}")
    public UserBO get(@PathVariable("id") Long id) {
        return userManger.get(id);
    }

    @HystrixCommand(commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100") }, fallbackMethod = "getByHysFallBack")
    @GetMapping(value = "/hys/{id}")
    public UserBO getByHys(@PathVariable("id") Long id) throws Exception {
        Thread.sleep(new Random().nextInt(200));
        return userManger.get(id);
    }

    public UserBO getByHysFallBack(Long id) {
        return new UserBO();
    }
}
