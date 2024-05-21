package com.lanshan.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.lanshan.PageHelper.AnnouncementPageQuery;
import com.lanshan.PageHelper.UserPageQuery;
import com.lanshan.Result.PageResult;
import com.lanshan.Result.Result;
import com.lanshan.entity.Dept;
import com.lanshan.entity.User;
import com.lanshan.service.DeptService;
import com.lanshan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
@Slf4j
@SaCheckRole("admin")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/{id}")
    public Result<Dept> getById(@PathVariable long id) {
        log.info("根据id查询部门：{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    @GetMapping("/page/user")
    public Result<PageResult> pageUser(UserPageQuery userPageQuery){
        log.info("部门员工分页查询，参数为：{}", userPageQuery);
        PageResult pageResult = deptService.pageQuery(userPageQuery);
        return Result.success(pageResult);
    }
    @GetMapping("/page/announcement")
    public Result<PageResult> pageAnnouncement(AnnouncementPageQuery announcementPageQuery){
        log.info("部门员工分页查询，参数为：{}", announcementPageQuery);
        PageResult pageResult = deptService.pageQueryAnnouncement(announcementPageQuery);
        return Result.success(pageResult);
    }

}
