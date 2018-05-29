/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.ribbon.controller;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hystrix超时动态设置
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-19 12:59
 */
@RestController
//@RefreshScope
public class DynamicHystrixCommandController {

    @Autowired
    private Environment environment;

    @GetMapping("/hystrix/change")
    public String changeTimeout() {
        int timeout = environment.getProperty("dynamic.hystrix.command.timeout", int.class, 100);
        return new DynamicHystrixCommand(timeout).execute();
    }

    private static class DynamicHystrixCommand extends HystrixCommand<String> {

        protected DynamicHystrixCommand(int timeout) {
            super(HystrixCommandGroupKey.Factory.asKey("DynamicHystrixCommand"),
                HystrixThreadPoolKey.Factory.asKey("DynamicHystrixCommand-ThreadPool-" + timeout), timeout);
        }

        @Override
        protected String run() throws Exception {
            Thread.sleep(new Random().nextInt(200));
            return "success";
        }

        protected String getFallback() {
            return "Fallback";
        }
    }
}
