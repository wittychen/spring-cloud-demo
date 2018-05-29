/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.user.service.impl;

import com.wittychen.cloudmall.user.api.bo.UserBO;
import com.wittychen.cloudmall.user.api.service.UserClientService;
import com.wittychen.cloudmall.user.manager.UserManger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这种方式web需要依赖服务的api
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-19 14:29
 */
@RestController
public class UserClientServiceImpl implements UserClientService {

    @Autowired
    private UserManger userManger;

    @Override
    public UserBO get(@PathVariable("id") Long id) {
        return userManger.get(id);
    }

    @Override
    public UserBO getName(Long id) {
        UserBO userBO = new UserBO();
        userBO.setName("李四");
        return userBO;
    }
}
