package com.lanshan.mapper;

import com.lanshan.entity.Announcement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnnouncementMapper {
    @Insert("INSERT INTO announcement (id,title,content,create_time,update_time,ano_dept_id)"+"" +
            "VALUES (#{id},#{title},#{content},#{createTime},#{updateTime},#{deptId})")
    void realse(Announcement announcement);
}
