package com.wittychen.cloudmall.user.api.bo;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-10 15:54
 */
@Data
public class UserBO implements Serializable {

    private static final long serialVersionUID = -7659690211615408990L;

    private Long id;

    private String name;
}
