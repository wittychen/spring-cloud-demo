/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.user.manager.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author chenfan
 * @version V1.0
 * @since 2018-05-26 13:21
 */
public interface UserMessage {

    String INPUT = "user-message";

    // 管道名称
    @Input(INPUT)
    SubscribableChannel input();
}
