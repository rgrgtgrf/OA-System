package com.lanshan.mapper;

import com.lanshan.entity.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO task (status,user_id,group_id)"+
            "VALUES (#{status},#{userId},#{groupId})")
    void insertTask(Task task);
    @Select("select * from task where group_id = #{id}")
    List<Task> getStatus(int id);
    @Update("update task set status = 1 where id = #{id}")
    void updateStatus(Integer id);
}
