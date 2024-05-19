package com.lanshan.service;

import com.lanshan.PageHelper.UserPageQuery;
import com.lanshan.Result.PageResult;
import com.lanshan.dto.UserDto;
import com.lanshan.entity.User;
import com.lanshan.vo.UserVo;

public interface UserService {
    void save(UserDto userDto);

    UserVo getById(long id);

    UserVo getByUsername(String username);

    PageResult pageQuery(UserPageQuery userPageQuery);

    User getByName(String username);
}
