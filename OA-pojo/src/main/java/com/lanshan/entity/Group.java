package com.lanshan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @NotNull(message = "小组ID不能为空", groups = {Role.Update.class, Create.class})
    private Integer id;
    /**
     * neirong
     */
    @NotBlank(message = "内容不能为空", groups = {Role.Create.class})
    @Length(min = 1, max = 500, message = "内容长度为 2 到 500 之间", groups = {Create.class, Update.class})
    private String content;
    /**
     * zhuangtai
     */
    @NotNull(message = "状态不能为空")
    private Integer Status;;
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

    @NotNull
    private Integer deptId;

    public interface Create {
    }

    public interface Update {
    }

}
