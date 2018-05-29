/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.web.client.fallback;

import com.wittychen.cloudmall.web.client.UserClient;
import com.wittychen.cloudmall.web.vo.UserVO;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 客户端UserClientFallback
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-19 16:04
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public UserVO get(Long id) {
        System.out.println("UserClient get fail!");
        return null;
    }

    @Override
    public UserVO getByHys(Long id) {
        System.out.println("UserClient getByHys fail!");
        return null;
    }
}
