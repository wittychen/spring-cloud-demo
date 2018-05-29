/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.web.controller.user;

import com.wittychen.cloudmall.user.api.bo.UserBO;
import com.wittychen.cloudmall.user.api.service.UserClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Client Controller
 * 需要依赖user-service的包
 * 不建议使用
 * @author chenfan
 * @version V1.0
 * @since 2018-05-19 14:36
 */
@RestController
public class UserClientController implements UserClientService{

    @Autowired
    private UserClientService userClientService;

    @Override
    public UserBO get(@PathVariable("id") Long id) {
        return userClientService.get(id);
    }

    @Override
    public UserBO getName(Long id) {
        return userClientService.getName(id);
    }
}
