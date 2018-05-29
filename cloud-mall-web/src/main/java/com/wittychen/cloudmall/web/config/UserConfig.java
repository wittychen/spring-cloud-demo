/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 用户配置
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-15 15:38
 */
@ConfigurationProperties(prefix = "user.service")
@Data
public class UserConfig {

    private Long id;

    private String name;

}
