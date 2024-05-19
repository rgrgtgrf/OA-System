package com.lanshan.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lanshan.PageHelper.UserPageQuery;
import com.lanshan.Result.PageResult;
import com.lanshan.entity.Dept;
import com.lanshan.entity.User;
import com.lanshan.mapper.DeptMapper;
import com.lanshan.mapper.UserMapper;
import com.lanshan.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Dept getById(long id) {
        return deptMapper.getById(id);
    }

    public PageResult pageQuery(UserPageQuery userPageQuery){
        PageHelper.startPage(userPageQuery.getPage(), userPageQuery.getPageSize());

        Page<User> page = userMapper.pageQuery(userPageQuery);
        long total = page.getTotal();
        List<User> users = page.getResult();

        return new PageResult(total,users);
    }
}
