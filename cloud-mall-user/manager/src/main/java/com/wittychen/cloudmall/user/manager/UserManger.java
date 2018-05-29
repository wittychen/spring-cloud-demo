/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.user.manager;

import com.wittychen.cloudmall.user.api.bo.UserBO;

/**
 * @author chenfan
 * @version V1.0
 * @since 2018-05-14 21:08
 */
public interface UserManger {

    UserBO get(Long id);

    Long add(UserBO userBO);

}
