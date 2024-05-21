package com.lanshan.controller;

import com.lanshan.Result.Result;
import com.lanshan.service.RequestService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    private RequestService requestService;
    @GetMapping("/{id}")
    public Result<Request> getRequest(@PathVariable int id) {
        return requestService.getById(id);
    }
}
