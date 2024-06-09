package com.lanshan.service;

import com.lanshan.PageHelper.UserPageQuery;
import com.lanshan.Result.PageResult;
import com.lanshan.Result.Result;
import com.lanshan.dto.UserDto;
import com.lanshan.entity.Announcement;
import com.lanshan.entity.Task;
import com.lanshan.entity.User;
import com.lanshan.vo.UserVo;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);

    UserVo getById(long id);

    UserVo getByUsername(String username);

    PageResult pageQuery(UserPageQuery userPageQuery);

    User getByName(String username);

    List<Task> getTask(Object loginId);

    Result updateTask(Integer id);

    void updateuser(UserDto userDto);
}
