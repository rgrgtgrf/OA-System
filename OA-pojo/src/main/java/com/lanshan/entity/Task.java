package com.lanshan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Integer id;
    @NotNull(message = "状态不能为空")
    private Integer Status;
    @NotNull(message = "用户ID不能为空", groups = {Role.Update.class, Group.Create.class})
    private Integer userId;
    @NotNull(message = "小组ID不能为空", groups = {Role.Update.class, Group.Create.class})
    private Integer groupId;
    @NotNull(message = "内容不能为空")
    private String content;
}
