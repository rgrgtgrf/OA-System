package com.lanshan.service;

import com.lanshan.Result.Result;
import com.lanshan.entity.Announcement;
import org.springframework.stereotype.Service;

@Service
public interface AnnouncementService {
    void release(Announcement announcement);
}
