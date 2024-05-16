package com.lanshan.oapojo.dto;

import com.lanshan.oapojo.entity.Dept;
import com.lanshan.oapojo.entity.Role;
import com.lanshan.oapojo.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    /**
     * touxiang
     */
    @NotBlank(message = "头像链接不能为空", groups = {Create.class})
    @URL(message = "头像链接必须是一个URL", groups = {Create.class, Update.class})
    private String profilePicture;

    @NotBlank(message = "用户名不能为空", groups = {User.Create.class})
    @Length(min = 2, max = 20, message = "用户名长度为 2 到 20 之间", groups = {User.Create.class, User.Update.class})
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = {User.Create.class})
    @Length(min = 6, max = 20, message = "密码长度为 6 到 20 之间", groups = {User.Create.class, User.Update.class})
    private String password;
    /**
     * 姓名
     */
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
    /**
     * 邮箱地址
     */
    @NotBlank(message = "邮箱地址不能为空", groups = {User.Create.class})
    @Email(message = "邮箱地址格式不正确", groups = {User.Create.class, User.Update.class})
    private String emailAddress;
    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空", groups = {User.Create.class})
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号码格式不正确", groups = {User.Create.class, User.Update.class})
    private String phoneNumber;
    public interface Create {
    }

    public interface Update {
    }
}
