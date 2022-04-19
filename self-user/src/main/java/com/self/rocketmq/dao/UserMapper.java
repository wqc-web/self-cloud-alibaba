package com.self.rocketmq.dao;

import com.self.rocketmq.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<User> queryUser(@Param("user") User user);
}