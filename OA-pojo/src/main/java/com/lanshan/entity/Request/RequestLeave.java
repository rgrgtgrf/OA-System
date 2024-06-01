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
public class RequestLeave {

    private int id;

    // 0 为请求失败 1 为审核中 2 为驳回 3 为成功
    @NotNull(message = "状态不能为空")
    private int status;

    private String content;

    private int deptId;
    private int userId;
}
