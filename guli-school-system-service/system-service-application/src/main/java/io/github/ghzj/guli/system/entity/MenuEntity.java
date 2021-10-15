package io.github.ghzj.guli.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Data
@TableName("system_menu")
public class MenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单资源编号
     */
    @TableId
    private Long id;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 权限标识(多个用逗号分隔，如：user:list,user:create)
     */
    private String permission;
    /**
     * 资源类型 0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 创建管理员编号
     */
    private Integer createAdminId;
    /**
     * 添加时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer deleted;

}