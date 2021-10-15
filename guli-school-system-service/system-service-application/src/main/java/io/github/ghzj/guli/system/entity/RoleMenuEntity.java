package io.github.ghzj.guli.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色菜单连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Data
@TableName("system_role_menu")
public class RoleMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 角色编号
     */
    private Long roleId;
    /**
     * 菜单编号
     */
    private Long menuId;
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