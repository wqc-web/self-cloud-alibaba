package com.self.content.dao;

import com.self.content.domain.entity.Content;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ContentMapper extends Mapper<Content> {
    List<Content> selectByUserAll(@Param("userId") Integer userId);
}