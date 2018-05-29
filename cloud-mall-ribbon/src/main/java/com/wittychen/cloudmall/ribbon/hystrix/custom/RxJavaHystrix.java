/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.ribbon.hystrix.custom;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Single;
import rx.schedulers.Schedulers;

/**
 * RxJava 实现
 * 响应式编程
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-19 12:35
 */
public class RxJavaHystrix {

    public static void main(String[] args) throws InterruptedException {
        //        doSingle();
        //        demoObservable();
        standardReactive();
    }

    public static void doSingle() {
        Single.just("single"). // 仅能发布单个数据
            subscribeOn(Schedulers.io()). // 在 I/O 线程执行
            subscribe(RxJavaHystrix::println); // 订阅并且消费数据
    }

    private static void demoObservable() throws InterruptedException {

        List<String> values = Arrays.asList("Observable1", "Observable2", "Observable3");
        Observable.from(values) //发布多个数据
            .subscribeOn(Schedulers.computation()) // 在 computation 线程执行
            .subscribe(RxJavaHystrix::println) // 订阅并且消费数据
        ;

        // 等待线程执行完毕
        Thread.sleep(100);

    }

    private static void standardReactive() throws InterruptedException {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
        Observable.from(values) //发布多个数据
            .subscribeOn(Schedulers.newThread()) // 在 newThread 线程执行
            .subscribe(value -> {
                if (value > 3)
                    throw new IllegalStateException("数据不应许大于 3");
                //消费数据
                println("消费数据：" + value);

            }, e -> {
                // 当异常情况，中断执行
                println("发生异常: " + e.getMessage());
            }, () -> {
                // 当整体流程完成时
                println("流程执行完成!");
            })

        ;

        // 等待线程执行完毕
        Thread.sleep(100);
    }

    public static void println(Object object) {
        System.out.println(Thread.currentThread().getName() + "_____" + object);
    }

}
