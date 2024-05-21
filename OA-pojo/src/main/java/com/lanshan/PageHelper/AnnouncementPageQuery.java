package com.lanshan.PageHelper;

import lombok.Data;

import java.io.Serializable;
@Data
public class AnnouncementPageQuery implements Serializable{

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

    //员工所在部门id
    private Long deptId;
}
