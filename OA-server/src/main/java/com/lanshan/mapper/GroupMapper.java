package com.lanshan.mapper;

import com.lanshan.entity.Group;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GroupMapper {
    @Insert("INSERT INTO group (status,create_time,update_time,content)"+
            "VALUES (#{status},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer createGroup(Group g);
    @Select("select * from group where dept_id = #{id}")
    Group getByDeptId(int id);

    void updateGroup(Group g);
    @Select("select * from group where id = #{id}")
    Group getById(Integer id);
}
