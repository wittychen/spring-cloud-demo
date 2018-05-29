/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.user.api.service;

import com.wittychen.cloudmall.user.api.bo.UserBO;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务客户端
 *  不与service provider耦合的方式
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-19 14:04
 */
@FeignClient(name = "cloud-mall-user-service")
public interface UserClientService {

    @GetMapping(value = "/user/client/{id}")
    UserBO get(@PathVariable("id") Long id);

    @GetMapping(value = "/user/client/name")
    UserBO getName(Long id);
}
