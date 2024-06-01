package com.lanshan.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.lanshan.Result.Result;
import com.lanshan.entity.Announcement;
import com.lanshan.service.AnnouncementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ano")
@Slf4j
public class AnnouncementController {
    @Autowired
    @Lazy
    private AnnouncementService annoService;

    @PostMapping("/release")@SaCheckRole("admin")
    public Result release(@Validated @RequestBody Announcement announcement){
        log.info("发布公告+{}",announcement);
        annoService.release(announcement);
        return Result.success();
    }
}
