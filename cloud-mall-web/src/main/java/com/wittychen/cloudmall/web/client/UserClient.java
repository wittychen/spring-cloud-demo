/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.web.client;

import com.wittychen.cloudmall.web.client.fallback.UserClientFallback;
import com.wittychen.cloudmall.web.vo.UserVO;

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
@FeignClient(name = "${service.name.user}",path = "/user",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping(value = "/{id}")
    UserVO get(@PathVariable("id") Long id);

    @GetMapping(value = "/hys/{id}")
    UserVO getByHys(@PathVariable("id") Long id);

}
