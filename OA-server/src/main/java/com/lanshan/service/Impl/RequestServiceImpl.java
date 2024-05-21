package com.lanshan.service.Impl;

import com.lanshan.Result.Result;
import com.lanshan.mapper.RequestMapper;
import com.lanshan.service.RequestService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestMapper requestMapper;
    @Override
    public Result<Request> getById(int id) {
        return Result.success(requestMapper.getById(id));
    }
}
