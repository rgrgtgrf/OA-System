package com.lanshan.service.Impl;

import com.lanshan.Result.Result;
import com.lanshan.entity.Request.RequestAdd;
import com.lanshan.entity.Request.RequestChange;
import com.lanshan.entity.Request.RequestLeave;
import com.lanshan.entity.User;
import com.lanshan.mapper.RequestMapper;
import com.lanshan.mapper.UserMapper;
import com.lanshan.service.RequestService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestMapper requestMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public RequestAdd getAddById(int id) {
        return requestMapper.getAddById(id);
    }

    @Override
    public RequestChange getChangeById(int id) {
        return requestMapper.getChangeById(id);
    }

    @Override
    public RequestLeave getLeaveById(int id) {
        return requestMapper.getLeaveById(id);
    }

    @Override
    public Result<Request> SendAdd(RequestAdd request) {
        return Result.success(requestMapper.updateAdd(request));
    }

    @Override
    public Result<Request> ChangeAdd(int id,int status) {
        RequestAdd request = new RequestAdd();
        request.setStatus(status);
        request.setId(id);
        if(status == 2){
            RequestAdd addById = requestMapper.getAddById(id);
            User user = new User();
            user.setId((long) addById.getUserId());
            user.setDeptId(addById.getDeptId());
            userMapper.updateUser(user);
        }
        return Result.success(requestMapper.updateAdd(request));
    }

    @Override
    public Result<Request> SendChange(RequestChange request) {
        return Result.success(requestMapper.updateChange(request));
    }

    @Override
    public Result<Request> ChangeChange1(int id, int status) {
        RequestChange request = new RequestChange();
        request.setStatus(status);
        request.setId(id);
        return Result.success(requestMapper.updateChange(request));
    }

    @Override
    public Result<Request> ChangeChange2(int id, int status) {
        if(requestMapper.getChangeById(id).getStatus() == 1){
            return Result.error("需要先由部门管理员审核");
        }
        RequestChange request = new RequestChange();
        request.setStatus(status);
        request.setId(id);
        if(status == 3){
            RequestChange changeById = requestMapper.getChangeById(id);
            User user = new User();
            user.setId((long) changeById.getUserId());
            user.setDeptId(changeById.getDeptId());
            userMapper.updateUser(user);
        }
        return Result.success(requestMapper.updateChange(request));
    }

    @Override
    public Result<Request> SendLeave(RequestLeave request) {
        return Result.success(requestMapper.updateLeave(request));
    }

    @Override
    public Result<Request> ChangeLeave(int id, int status) {
        RequestLeave request = new RequestLeave();
        request.setStatus(status);
        request.setId(id);
        return Result.success(requestMapper.updateLeave(request));
    }
}
