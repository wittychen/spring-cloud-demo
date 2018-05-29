/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.ribbon.hystrix.custom;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * future模式熔断
 * 超时熔断
 * @author chenfan
 * @version V1.0
 * @since 2018-05-19 12:08
 */
public class FutureHystrix {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        TimeoutCommand timeoutCommand = new TimeoutCommand();
        Future<String> future = executorService.submit(timeoutCommand::run);
        String result;
        try {
            result = future.get(100, TimeUnit.MILLISECONDS);

        }catch (Exception e){
            result = timeoutCommand.fallBack();
        }
        System.out.println(result);
        executorService.shutdown();
    }

    public static class TimeoutCommand implements Command {

        @Override
        public String run() throws Exception {
            Thread.sleep(new Random().nextInt(200));
            return "success";
        }

        @Override
        public String fallBack() {
            return "fallBack";
        }
    }

    public interface Command<T> {
        T run() throws Exception;

        T fallBack();
    }
}
