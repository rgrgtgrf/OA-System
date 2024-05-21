package com.lanshan.mapper;

import com.github.pagehelper.Page;
import com.lanshan.PageHelper.AnnouncementPageQuery;
import com.lanshan.PageHelper.UserPageQuery;
import com.lanshan.Result.Result;
import com.lanshan.entity.Announcement;
import com.lanshan.entity.Task;
import com.lanshan.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (username, password, full_name, gender, dept_id, email_address, phone_number, profile_picture, create_time, update_time, roles)"
            + " VALUES (#{username}, #{password}, #{fullName}, #{gender}, #{deptId}, #{emailAddress}, #{phoneNumber}, #{profilePicture}, #{createTime}, #{updateTime}, #{roles})")
    void insert(User user);

    @Select("select * from user where id = #{id}")
    User getById(long id);

    @Select("select * from user where username = #{username}")
    User getByUsername(String username);

    Page<User> pageQuery(UserPageQuery userPageQuery);

    @Insert("INSERT INTO announcement (title,content,create_time,update_time,ano_dept_id)"
    +"VALUES (#{title},#{content},#{createTime},#{updateTime},#{deptId})")
    void saveAnnouncement(Announcement announcement);
    @Select("select * from task where user_id = #{loginId}")
    List<Task> getTask(Object loginId);
}
