/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.web.controller.user;

import com.wittychen.cloudmall.user.api.bo.UserBO;
import com.wittychen.cloudmall.web.client.UserClient;
import com.wittychen.cloudmall.web.config.UserConfig;
import com.wittychen.cloudmall.web.vo.UserVO;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-15 16:52
 */
@RestController
@RequestMapping("/user")
@EnableConfigurationProperties(UserConfig.class)
public class UserController {

    @Autowired
    private UserConfig userConfig;

    @Autowired
    private UserClient userClient;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Long id) {
        return userClient.get(id);
    }

    @GetMapping(value = "/hys/{id}")
    public UserVO getByHys(@PathVariable("id") Long id) {
        return userClient.getByHys(id);
    }

    @GetMapping("/config")
    public UserConfig getConfig() {
        return userConfig;
    }

    @GetMapping("/advice/{id}")
    public UserVO getAdvice(@PathVariable("id") Long id) throws Exception {
        Random random = new Random();
        int randomNum = random.nextInt(1000);
        if (randomNum > 500)
            throw new TimeoutException("timeout!");
        return new UserVO();
    }

    @GetMapping("/send")
    public Boolean send(String name) {
        UserBO userBO = new UserBO();
        userBO.setName(name);
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(
            "cloud-mall-web-user", 0, userBO);
        return future.isDone();
    }
}
