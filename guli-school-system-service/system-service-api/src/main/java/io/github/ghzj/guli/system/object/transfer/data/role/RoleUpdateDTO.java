package io.github.ghzj.guli.system.object.transfer.data.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 系统角色
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("系统角色 更新 Request DTO")
public class RoleUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编号")
    private Long id;
    /**
     * 角色名
     */
    @ApiModelProperty(value = "角色名")
    private String name;
    /**
     * 角色类型，0 系统角色，1 自定义角色
     */
    @ApiModelProperty(value = "角色类型，0 系统角色，1 自定义角色")
    private Integer type;
    /**
     * 创建管理员编号
     */
    @ApiModelProperty(value = "创建管理员编号")
    private Integer createAdminId;
    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer deleted;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}