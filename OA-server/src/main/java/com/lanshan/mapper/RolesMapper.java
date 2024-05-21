package com.lanshan.mapper;

import com.lanshan.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RolesMapper {
    @Select("select * from role where name = #{roles}")
    List<Role> getByName(String roles);
}
