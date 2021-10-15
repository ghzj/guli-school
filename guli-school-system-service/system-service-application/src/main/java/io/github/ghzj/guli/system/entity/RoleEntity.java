package io.github.ghzj.guli.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统角色
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Data
@TableName("system_role")
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    @TableId
    private Long id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 角色类型，0 系统角色，1 自定义角色
     */
    private Integer type;
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
    /**
     * 备注
     */
    private String remark;

}