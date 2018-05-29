/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.user.manager.impl;

import static com.wittychen.cloudmall.user.manager.stream.UserMessage.INPUT;

import com.wittychen.cloudmall.user.api.bo.UserBO;
import com.wittychen.cloudmall.user.manager.UserManger;
import com.wittychen.cloudmall.user.manager.stream.UserMessage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

/**
 * @author chenfan
 * @version V1.0
 * @since 2018-05-26 13:35
 */
@Service
public class UserMessageManagerImpl {
    @Autowired
    private UserMessage userMessage;

    @Autowired
    private UserManger userManger;

    @ServiceActivator(inputChannel = INPUT)
    public void listen(byte[] data) {
        System.out.println("Subscribe by @ServiceActivator");
        saveUser(data);
    }

    @StreamListener(INPUT)
    public void onMessage(byte[] data) throws IOException {
        System.out.println("Subscribe by @StreamListener");
        saveUser(data);
    }

    private void saveUser(byte[] data) {
        // message body 是字节流 byte[]
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            UserBO userBO = (UserBO) objectInputStream.readObject(); // 反序列化成 User 对象
            userManger.add(userBO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void init() {
        SubscribableChannel subscribableChannel = userMessage.input();
        subscribableChannel.subscribe(message -> {
            System.out.println("Subscribe by SubscribableChannel");
            // message body 是字节流 byte[]
            byte[] body = (byte[]) message.getPayload();
            saveUser(body);
        });
    }
}
