package com.lanshan.oaserver.controller;

import com.lanshan.oacommon.Result.Result;
import com.lanshan.oapojo.dto.UserDto;
import com.lanshan.oapojo.entity.User;
import com.lanshan.oapojo.vo.UserVo;
import com.lanshan.oaserver.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<UserVo> login(@RequestBody UserDto userDto){

        return null;
    }

    @PostMapping("/register")
    public Result<UserVo> save(@RequestBody UserDto userDto){
        userService.save(userDto);
        return null;
    }
}
