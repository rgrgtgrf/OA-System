package com.lanshan.PageHelper;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPageQuery implements Serializable {

    //员工姓名
    private String name;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

    //员工所在部门id
    private int deptId;
}
