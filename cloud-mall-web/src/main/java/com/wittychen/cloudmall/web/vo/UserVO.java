/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.wittychen.cloudmall.web.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户VO
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-15 15:38
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -196411951874917052L;

    private Long id;

    private String name;

}
