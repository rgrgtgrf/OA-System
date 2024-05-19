package com.lanshan.vo;

import com.lanshan.entity.Dept;
import com.lanshan.entity.User;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.ConvertGroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

    @NotBlank(message = "用户名不能为空", groups = {User.Create.class})
    @Length(min = 2, max = 20, message = "用户名长度为 2 到 20 之间", groups = {User.Create.class, User.Update.class})
    private String username;
    @NotBlank(message = "姓名不能为空", groups = {User.Create.class})
    @Length(min = 2, max = 10, message = "姓名长度为 2 到 10 之间", groups = {User.Create.class, User.Update.class})
    private String fullName;
    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空", groups = {User.Create.class})
    @Pattern(regexp = "^([男女])$", message = "性别只能为男或女", groups = {User.Create.class, User.Update.class})
    private String gender;
    /**
     * 部门
     */
    @NotNull(message = "部门不能为空", groups = {User.Create.class})
    private String dept;
    /**
     * 角色
     */
    @NotEmpty(message = "角色不能为空", groups = {User.Create.class})
    private String roles;
}
