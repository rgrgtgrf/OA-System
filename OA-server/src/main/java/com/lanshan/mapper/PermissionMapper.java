package com.lanshan.mapper;

import com.lanshan.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {
    @Select("select * from permission where id = #{id}")
    List<Permission> getpermission(Integer id);
}
