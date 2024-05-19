package com.lanshan.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lanshan.PageHelper.UserPageQuery;
import com.lanshan.Result.PageResult;
import com.lanshan.dto.UserDto;
import com.lanshan.entity.User;
import com.lanshan.mapper.DeptMapper;
import com.lanshan.mapper.UserMapper;
import com.lanshan.service.UserService;
import com.lanshan.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void save(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
        user.setUpdateTime(LocalDateTime.now());
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
    }
    @Override
    public UserVo getById(long id) {
        UserVo uservo = new UserVo();
        BeanUtils.copyProperties(userMapper.getById(id),uservo);
        uservo.setDept(deptMapper.getById(id).getName());
        return uservo;
    }

    @Override
    public UserVo getByUsername(String username) {
        UserVo uservo = new UserVo();
        User user = userMapper.getByUsername(username);
        BeanUtils.copyProperties(user,uservo);
        uservo.setDept(deptMapper.getById(user.getDeptId()).getName());
        return uservo;
    }

    public PageResult pageQuery(UserPageQuery userPageQuery){
        PageHelper.startPage(userPageQuery.getPage(), userPageQuery.getPageSize());
        Page<User> page = userMapper.pageQuery(userPageQuery);
        long total = page.getTotal();
        List<User> users = page.getResult();

        return new PageResult(total,users);
    }

    @Override
    public User getByName(String username) {
        return userMapper.getByUsername(username);
    }

}
