package io.github.ghzj.guli.system.object.transfer.data.role.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 角色菜单连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("角色菜单连表 添加 Request DTO")
public class RoleMenuSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Long id;
    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编号")
    private Long roleId;
    /**
     * 菜单编号
     */
    @ApiModelProperty(value = "菜单编号")
    private Long menuId;
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
}