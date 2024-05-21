package com.lanshan.service.Impl;

import com.lanshan.Result.Result;
import com.lanshan.dto.GroupDto;
import com.lanshan.entity.Group;
import com.lanshan.entity.Task;
import com.lanshan.mapper.GroupMapper;
import com.lanshan.mapper.TaskMapper;
import com.lanshan.mapper.UserMapper;
import com.lanshan.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public String create(GroupDto group) {
        //检测user的部门是不是一样的
        Integer idini = userMapper.getById(group.getUserIds().get(0)).getDeptId();
        for(Integer id:group.getUserIds()){
            if(userMapper.getById(id).getDeptId()!=idini){
                return "创建失败，用户必须在一个部门才能创建小组";
            }
        }
        Group g = new Group();
        BeanUtils.copyProperties(group,g);
        g.setCreateTime(LocalDateTime.now());
        g.setUpdateTime(LocalDateTime.now());
        g.setDeptId(idini);
        Integer gid = groupMapper.createGroup(g);
        int cnt = 0;
        for(Integer id:group.getUserIds()){
            Task task = new Task();
            task.setStatus(0);
            task.setGroupId(gid);
            task.setUserId(id);
            task.setContent(group.getTaskContent().get(cnt));
            taskMapper.insertTask(task);
            cnt++;
        }
        return "创建成功";
    }

    @Override
    public Group getByDeptId(int id) {
        return groupMapper.getByDeptId(id);
    }

    @Override
    public double getStatus(int id) {
        List<Task> status = taskMapper.getStatus(id);
        int cnt = 0;
        for(Task task:status){
            if(task.getStatus()==1){
                cnt++;
            }
        }
        return (double) cnt /status.size();
    }

    @Override
    public Result updateGroup(GroupDto group) {
        Group byId = groupMapper.getById(group.getId());
        groupMapper.updateGroup(byId);
        return Result.success("修改成功");
    }
}
