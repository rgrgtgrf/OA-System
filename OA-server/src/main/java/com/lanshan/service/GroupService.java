package com.lanshan.service;

import com.lanshan.Result.Result;
import com.lanshan.dto.GroupDto;
import com.lanshan.entity.Group;
import org.springframework.stereotype.Service;

@Service
public interface GroupService {
    String create(GroupDto group);

    Group getByDeptId(int id);

    double getStatus(int id);

    Result updateGroup(GroupDto group);
}
