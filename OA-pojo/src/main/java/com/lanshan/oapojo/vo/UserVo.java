package com.lanshan.oapojo.vo;

import com.lanshan.oapojo.entity.Dept;
import com.lanshan.oapojo.entity.Role;
import com.lanshan.oapojo.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.ConvertGroup;
import org.hibernate.validator.constraints.Length;

import java.util.List;

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
    @Valid
    @ConvertGroup.List({@ConvertGroup(from = User.Create.class, to = Dept.UserNested.class)})
    private Dept dept;
    /**
     * 角色
     */
    @NotEmpty(message = "角色不能为空", groups = {User.Create.class})
    private List<@Valid @ConvertGroup.List({@ConvertGroup(from = User.Create.class, to = Role.UserNested.class)}) Role> roles;
}
