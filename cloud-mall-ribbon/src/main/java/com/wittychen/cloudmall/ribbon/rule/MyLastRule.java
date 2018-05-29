/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义规则，选择最后一个服务
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-18 14:09
 */
public class MyLastRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {

        // 获取所有可达服务列表
        ILoadBalancer iLoadBalancer = getLoadBalancer();
        List<Server> allServers = iLoadBalancer.getAllServers();
        if (allServers.isEmpty())
            return null;
        // 选择最后一台可达的服务器
        return allServers.get(allServers.size() - 1);
    }
}
