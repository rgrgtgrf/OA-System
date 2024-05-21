package com.lanshan.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.lanshan.Result.Result;
import com.lanshan.dto.GroupDto;
import com.lanshan.entity.Group;
import com.lanshan.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
@SaCheckRole("admin")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @PostMapping("/create")
    public String createGroup(@RequestBody GroupDto group) {
        return groupService.create(group);
    }
    @GetMapping("/look/{id}")
    public Group lookGroup(@RequestParam@PathVariable int id) {
        return groupService.getByDeptId(id);
    }
    @GetMapping("/complete/{id}")
    public double completeGroup(@RequestParam int id) {
        return groupService.getStatus(id);
    }
    @PostMapping("/update")
    public Result updateGroup(@RequestBody GroupDto group) {
        if(groupService.getStatus(group.getId()) == 1) {
            return Result.error("无法对已完成的工作内容进行编辑");
        }
        return groupService.updateGroup(group);
    }
}
