package com.lanshan.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.lanshan.Result.Result;
import com.lanshan.entity.Request.RequestAdd;
import com.lanshan.entity.Request.RequestChange;
import com.lanshan.entity.Request.RequestLeave;
import com.lanshan.service.RequestService;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    private RequestService requestService;
    @GetMapping("/Add/{id}")
    public RequestAdd getAddRequest(@PathVariable int id) {
        return requestService.getAddById(id);
    }
    @GetMapping("/Change/{id}")
    public RequestChange getChangeRequest(@PathVariable int id) {
        return requestService.getChangeById(id);
    }
    @GetMapping("/Leave/{id}")
    public RequestLeave getLeaveRequest(@PathVariable int id) {
        return requestService.getLeaveById(id);
    }
    @PostMapping("/Add/send")
    @ApiOperation("加入部门请求")
    public Result<Request> sendAddRequest(@RequestBody RequestAdd request) {
        if(request.getStatus()!=0){
            return Result.error("请求失败，请求状态不能非零");
        }
        return requestService.SendAdd(request);
    }
    @PostMapping("/Change/change/{id}")
    @SaCheckRole("admin")
    @ApiOperation("审核加入部门请求")
    public Result<Request> AddChange(@PathVariable int id, @RequestBody int status) {
        return requestService.ChangeAdd(id,status);
    }
    @PostMapping("/Change/send")
    @ApiOperation("更改部门请求")
    public Result<Request> sendChangeRequest(@RequestBody RequestChange request) {
        if(request.getStatus()!=0){
            return Result.error("请求失败，请求状态不能非零");
        }
        return requestService.SendChange(request);
    }
    @PostMapping("/Change/change1/{id}")
    @SaCheckRole("admin")
    @ApiOperation("管理员审核更改部门请求")
    public Result<Request> ChangeChange1(@PathVariable int id, @RequestBody int status) {
        if(status == 3){
            return Result.error("你没有此权力");
        }
        return requestService.ChangeChange1(id,status);
    }
    @PostMapping("/Change/change2/{id}")
    @SaCheckRole("super-admin")
    @ApiOperation("老板审核更改部门请求")
    public Result<Request> ChangeChange2(@PathVariable int id, @RequestBody int status) {
        return requestService.ChangeChange2(id,status);
    }
    @PostMapping("/Leave/send")
    @ApiOperation("请假请求")
    public Result<Request> sendLeaveRequest(@RequestBody RequestLeave request) {
        if(request.getStatus()!=0){
            return Result.error("请求失败，请求状态不能非零");
        }
        return requestService.SendLeave(request);
    }
    @PostMapping("/Leave/change/{id}")
    @SaCheckRole("admin")
    @ApiOperation("审核请假请求")
    public Result<Request> LeaveChange(@PathVariable int id, @RequestBody int status) {
        return requestService.ChangeLeave(id,status);
    }
}
