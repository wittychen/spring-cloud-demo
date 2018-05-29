/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.consul.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Consul服务注册于发现
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-16 21:10
 */
@RestController
@RequestMapping("/consul")
public class ConsulDiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String currentApplicationName;

    /**
     * 获取当前应用信息
     */
    @GetMapping("/service-instance")
    public ServiceInstance getCurrentServiceInstance() {
        //        return discoveryClient.getInstances(currentApplicationName).get(0);
        return discoveryClient.getLocalServiceInstance();

    }

    /**
     * 获取所有的服务名
     */
    @GetMapping("/service/list")
    public List<String> listServices() {
        return discoveryClient.getServices();
    }

    /**
     * 获取所有的服务实例信息
     */
    @GetMapping("/instances/list")
    public List<ServiceInstance> listServiceInstances() {
        List<String> services = listServices();
        List<ServiceInstance> serviceInstances = new LinkedList<>();
        services.forEach(serviceName -> serviceInstances.addAll(discoveryClient.getInstances(serviceName)));
        return serviceInstances;
    }
}
