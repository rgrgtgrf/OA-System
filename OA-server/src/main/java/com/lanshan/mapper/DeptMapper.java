package com.lanshan.mapper;

import com.github.pagehelper.Page;
import com.lanshan.PageHelper.AnnouncementPageQuery;
import com.lanshan.entity.Dept;
import com.lanshan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptMapper {
    @Select("select * from dept where id = #{id}")
    Dept getById(long id);

    @Select("select * from announcement where dept_id = #{id}")
    Page<User> PageQuery(Long id);
}
