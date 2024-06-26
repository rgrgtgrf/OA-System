package com.lanshan.entity.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestChange {

    private int id;

    // 0 为请求失败 1 为部门审核中 2 为管理员审核中 3为成功
    @NotNull(message = "状态不能为空")
    private int status;

    private String content;

    private int deptId;

    private int userId;
}
