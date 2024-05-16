package com.lanshan.oapojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.*;


import java.time.LocalDateTime;

@Data
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    /**
     * 主键ID
     */
    @NotNull(message = "角色ID不能为空", groups = {Update.class, UserNested.class})
    private Integer id;
    /**
     * 角色名
     */
    @NotBlank(message = "角色名不能为空", groups = {Create.class})
    @Length(min = 2, max = 10, message = "角色名长度为 2 到 10 之间", groups = {Create.class, Update.class})
    private String name;
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
