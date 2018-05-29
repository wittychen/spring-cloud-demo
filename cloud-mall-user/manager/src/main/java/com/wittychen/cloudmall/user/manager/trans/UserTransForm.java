/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.user.manager.trans;

import com.wittychen.cloudmall.user.api.bo.UserBO;
import com.wittychen.cloudmall.user.dal.po.UserPO;

/**
 * @author chenfan
 * @version V1.0
 * @since 2018-05-14 21:11
 */
public class UserTransForm {

    private UserTransForm() {
    }

    public static UserBO trans(UserPO userPO) {
        if (userPO == null) {
            return null;
        }
        UserBO userBO = new UserBO();
        userBO.setId(userPO.getId());
        userBO.setName(userPO.getName());
        return userBO;
    }

    public static UserPO trans(UserBO userBO) {
        if (userBO == null) {
            return null;
        }
        UserPO userPO = new UserPO();
        userPO.setId(userBO.getId());
        userPO.setName(userBO.getName());
        return userPO;
    }
}
