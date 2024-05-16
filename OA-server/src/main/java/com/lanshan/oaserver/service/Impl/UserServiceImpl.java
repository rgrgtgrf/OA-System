package com.lanshan.oaserver.service.Impl;

import com.lanshan.oapojo.dto.UserDto;
import com.lanshan.oapojo.entity.User;
import com.lanshan.oaserver.mapper.UserMapper;
import com.lanshan.oaserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void save(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }
}
