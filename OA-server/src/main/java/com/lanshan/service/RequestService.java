package com.lanshan.service;

import com.lanshan.Result.Result;
import com.lanshan.entity.Request.RequestAdd;
import com.lanshan.entity.Request.RequestChange;
import com.lanshan.entity.Request.RequestLeave;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Service;

@Service
public interface RequestService {
    RequestAdd getAddById(int id);

    RequestChange getChangeById(int id);

    RequestLeave getLeaveById(int id);

    Result<Request> SendAdd(RequestAdd request);

    Result<Request> ChangeAdd(int id,int status);

    Result<Request> SendChange(RequestChange request);

    Result<Request> ChangeChange1(int id, int status);

    Result<Request> ChangeChange2(int id, int status);

    Result<Request> SendLeave(RequestLeave request);

    Result<Request> ChangeLeave(int id, int status);
}
