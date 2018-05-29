/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.user.manager.impl;

import com.wittychen.cloudmall.user.api.bo.UserBO;
import com.wittychen.cloudmall.user.dal.mapper.UserMapper;
import com.wittychen.cloudmall.user.dal.po.UserPO;
import com.wittychen.cloudmall.user.manager.UserManger;
import com.wittychen.cloudmall.user.manager.trans.UserTransForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenfan
 * @version V1.0
 * @since 2018-05-14 21:09
 */
@Service
public class UserMangerImpl implements UserManger {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBO get(Long id) {
        return UserTransForm.trans(userMapper.selectByPrimaryKey(id));
    }

    @Override
    public Long add(UserBO userBO) {
        UserPO userPO = UserTransForm.trans(userBO);
        userMapper.insert(userPO);
        return userPO.getId();
    }
}
