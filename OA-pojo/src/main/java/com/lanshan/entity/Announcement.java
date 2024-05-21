package com.lanshan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {

    /**
     * 主键ID
     */
    @NotNull(message = "ID不能为空", groups = {Update.class})
    private Long id;
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空", groups = {Create.class})
    @Length(min = 5, max = 50, message = "标题长度为 5 到 50 之间", groups = {Create.class, Update.class})
    private String title;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空", groups = {Create.class})
    @Length(min = 5, max = 2000, message = "内容长度为 5 到 2000 之间", groups = {Create.class, Update.class})
    private String content;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @NotNull
    private Long deptId;

    public interface Create {
    }

    public interface Update {
    }

}



