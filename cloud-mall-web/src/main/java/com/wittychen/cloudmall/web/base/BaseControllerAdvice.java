/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.web.base;

import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller增强
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-18 18:03
 */
@RestControllerAdvice
//@RestControllerAdvice(assignableTypes = UserController.class)
public class BaseControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(BaseControllerAdvice.class);

    @ExceptionHandler(TimeoutException.class)
    public Object timeoutException(TimeoutException ex) {
        LOG.error("timeout,ex：{}", ex);
        return ex;
    }
}
