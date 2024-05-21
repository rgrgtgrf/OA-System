package com.lanshan.service.Impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.lanshan.entity.Permission;
import com.lanshan.entity.User;
import com.lanshan.entity.Role;
import com.lanshan.mapper.PermissionMapper;
import com.lanshan.mapper.RolesMapper;
import com.lanshan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限加载接口实现类
 */
@Component    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RolesMapper rolesMapper;

    /**
     * 返回一个账号所拥有的权限码集合 
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        User user = userMapper.getById((Long) loginId);
        List<Role> role = rolesMapper.getByName(user.getRoles());
        List<String> list = new ArrayList<>();
        for(Role r : role) {
            for(Permission p : permissionMapper.getpermission(r.getId())){
                list.add(p.getName());
            }
        }
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        User user = userMapper.getById((Long) loginId);
        List<String> list = new ArrayList<>();
        for(Role r : rolesMapper.getByName(user.getRoles())){
            list.add(r.getName());
        }
        return list;
    }

}
