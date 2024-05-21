package com.lanshan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.lanshan.PageHelper.UserPageQuery;
import com.lanshan.Result.PageResult;
import com.lanshan.Result.Result;
import com.lanshan.dto.UserDto;
import com.lanshan.entity.Task;
import com.lanshan.entity.User;
import com.lanshan.mapper.UserMapper;
import com.lanshan.service.DeptService;
import com.lanshan.vo.UserVo;
import com.lanshan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")@SaCheckRole("admin")
    public Result<UserVo> getById(@PathVariable long id) {
        log.info("根据id查询员工：{}", id);
        UserVo uservo = userService.getById(id);
        return Result.success(uservo);
    }

    @GetMapping("/{username}")@SaCheckRole("admin")
    public Result<UserVo> getById(@PathVariable String username) {
        log.info("根据id查询员工：{}", username);
        UserVo uservo = userService.getByUsername(username);
        return Result.success(uservo);
    }

    @PostMapping("/login")
    public Result<String> login(String username, String password){
        User user = userService.getByName(username);
        if(user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
            StpUtil.login(user.getId());
            return Result.success("登录成功");
        }
        return Result.error("登陆失败");
    }

    @PostMapping("/logout")@SaCheckLogin
    public Result<String> logout(){
        return Result.success("登陆成功");
    }

    @PostMapping("/register")@SaCheckRole("admin")
    public Result save(@Validated@RequestBody UserDto userDto){
        log.info("注册账号+{}",userDto.getUsername());
        userService.save(userDto);
        return Result.success();
    }
    @GetMapping("/page")@SaCheckRole("admin")
    public Result<PageResult> page(@RequestBody UserPageQuery userPageQuery){
        log.info("员工分页查询，参数为：{}", userPageQuery);
        PageResult pageResult = userService.pageQuery(userPageQuery);
        return Result.success(pageResult);
    }

    @GetMapping("/task")
    public List<Task> TaskQuery(){
        return userService.getTask(StpUtil.getLoginId());
    }
    @PostMapping("/submit/{id}")
    public Result submit(@Validated @RequestBody Integer id){
        return userService.updateTask(id);
    }
}
