package com.lanshan.service.Impl;

import com.lanshan.Result.Result;
import com.lanshan.entity.Announcement;
import com.lanshan.mapper.AnnouncementMapper;
import com.lanshan.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public void release(Announcement announcement) {
        announcementMapper.realse(announcement);
    }
}
