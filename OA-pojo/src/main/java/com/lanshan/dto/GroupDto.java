package com.lanshan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lanshan.entity.Group;
import com.lanshan.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    @NotNull(message = "小组ID不能为空", groups = {Role.Update.class, Group.Create.class})
    private Integer id;
    /**
     * neirong
     */
    @NotBlank(message = "内容不能为空", groups = {Role.Create.class})
    @Length(min = 1, max = 500, message = "内容长度为 2 到 500 之间", groups = {Group.Create.class, Group.Update.class})
    private String content;
    /**
     * zhuangtai
     */
    @NotNull(message = "状态不能为空")
    private Integer Status;;

    @NotNull
    List<Integer> userIds = new ArrayList<>();

    @NotNull
    List<String> taskContent = new ArrayList<>();

    public interface Create {
    }

    public interface Update {
    }

}

