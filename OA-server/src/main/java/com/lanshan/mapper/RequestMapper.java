package com.lanshan.mapper;

import com.lanshan.Result.Result;
import org.apache.catalina.connector.Request;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RequestMapper {
    @Select("select * from request where id = #{id}")
    Request getById(int id);
}
