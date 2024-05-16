package com.lanshan.oaserver.mapper;

import com.lanshan.oapojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("")
    public void insert(User user);
}
