package com.lanshan.mapper;

import com.lanshan.Result.Result;
import com.lanshan.entity.Request.RequestAdd;
import com.lanshan.entity.Request.RequestChange;
import com.lanshan.entity.Request.RequestLeave;
import org.apache.catalina.connector.Request;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RequestMapper {
    @Select("select * from requestAdd where id = #{id}")
    RequestAdd getAddById(int id);

    @Select("select * from requestChange where id = #{id}")
    RequestChange getChangeById(int id);

    @Select("select * from requestLeave where id = #{id}")
    RequestLeave getLeaveById(int id);


    Request updateAdd(RequestAdd request);

    Request updateChange(RequestChange request);

    Request updateLeave(RequestLeave request);
}
