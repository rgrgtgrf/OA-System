package com.lanshan.oapojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    /**
     * 主键ID
     */
    @NotNull(message = "部门ID不能为空", groups = {Update.class, UserNested.class})
    private Integer id;
    /**
     * 部门名
     */
    @NotBlank(message = "部门名不能为空", groups = {Create.class})
    @Length(min = 2, max = 10, message = "部门名长度为 2 到 10 之间", groups = {Create.class, Update.class})
    private String name;
    /**
     * 负责人
     */
    @Length(min = 2, max = 10, message = "负责人长度为 2 到 10 之间", groups = {Create.class, Update.class})
    private String principal;
    /**
     * 手机号码
     */
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号码格式不正确", groups = {Create.class, Update.class})
    private String phoneNumber;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    public interface Create {
    }

    public interface Update {
    }

    public interface UserNested {
    }

}
