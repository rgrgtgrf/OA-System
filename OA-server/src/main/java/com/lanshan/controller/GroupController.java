package com.lanshan.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.lanshan.Result.Result;
import com.lanshan.dto.GroupDto;
import com.lanshan.entity.Group;
import com.lanshan.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
@SaCheckRole("admin")
@Api(tags = "工作相关接口")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    @ApiOperation("新增小组")
    public String createGroup(@RequestBody GroupDto group) {
        return groupService.create(group);
    }

    @GetMapping("/look/{id}")
    @ApiOperation("获取小组所在部门")
    public Group lookGroup(@RequestParam@PathVariable int id) {
        return groupService.getByDeptId(id);
    }

    @GetMapping("/complete/{id}")
    @ApiOperation("获取工作进度")
    public double completeGroup(@RequestParam int id) {
        return groupService.getStatus(id);
    }

    @PostMapping("/update")
    @ApiOperation("更新工作内容")
    public Result updateGroup(@RequestBody GroupDto group) {
        if(groupService.getStatus(group.getId()) == 1) {
            return Result.error("无法对已完成的工作内容进行编辑");
        }
        return groupService.updateGroup(group);
    }
}
