package com.wittychen.cloudmall.user.dal.mapper;

import com.wittychen.cloudmall.user.dal.po.UserPO;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPO record);

    UserPO selectByPrimaryKey(Long id);

    List<UserPO> selectAll();

    int updateByPrimaryKey(UserPO record);
}