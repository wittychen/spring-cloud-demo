/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.ribbon.ping;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 检查服务的健康状态
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-18 14:28
 */
public class MyPing implements IPing {

    @Override
    public boolean isAlive(Server server) {
        String host = server.getHost();
        int port = server.getPort();
        // /health endpoint
        // 通过 Spring 组件来实现URL 拼装
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.scheme("http");
        builder.host(host);
        builder.port(port);
        builder.path("/info");
        URI uri = builder.build().toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(uri, String.class);
        } catch (Exception e) {
            return false;
        }
        // 当响应状态等于 200 时，返回 true ，否则 false
        return HttpStatus.OK.equals(responseEntity.getStatusCode());
    }

}
