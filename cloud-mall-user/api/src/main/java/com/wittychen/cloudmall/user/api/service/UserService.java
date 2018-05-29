package com.wittychen.cloudmall.user.api.service;

import com.wittychen.cloudmall.user.api.bo.UserBO;

/**
 * 用户服务
 *
 * @author chenfan
 * @version V1.0
 * @since 2018-05-10 16:43
 */
public interface UserService {

    UserBO get(Long id);
}
