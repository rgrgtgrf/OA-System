package com.lanshan.service;

import com.lanshan.PageHelper.AnnouncementPageQuery;
import com.lanshan.PageHelper.UserPageQuery;
import com.lanshan.Result.PageResult;
import com.lanshan.entity.Dept;
import com.lanshan.entity.User;

public interface DeptService {
    Dept getById(long id);

    PageResult pageQuery(UserPageQuery userPageQuery);

    PageResult pageQueryAnnouncement(AnnouncementPageQuery announcementPageQuery);
}
