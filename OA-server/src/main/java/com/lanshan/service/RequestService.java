package com.lanshan.service;

import com.lanshan.Result.Result;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Service;

@Service
public interface RequestService {
    Result<Request> getById(int id);
}
