package com.lanshan.oapojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.net.http.HttpClient;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    /**
     * 主键ID
     */
    @NotNull(message = "权限ID不能为空", groups = {Update.class})
    private Integer id;
    /**
     * 权限名
     */
    @NotBlank(message = "权限名不能为空", groups = {Create.class})
    @Length(min = 2, max = 20, message = "权限名长度为 2 到 20 之间", groups = {Create.class, Update.class})
    private String name;
    /**
     * 类型
     */
    @NotNull(message = "权限类型不能为空", groups = {Create.class})
    private Type type;
    /**
     * 父级ID
     */
    @NotNull(message = "父级ID不能为空", groups = {Create.class})
    private Integer parentId;
    /**
     * 请求方法
     */
    private String requestMethod;
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
    public enum Type {
        /**
         * 分类
         */
        category,
        /**
         * 菜单
         */
        menu,
        /**
         * 资源
         */
        resource
    }

    public interface Create {
    }

    public interface Update {
    }

}
