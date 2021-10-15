package io.github.ghzj.guli.system.object.transfer.data.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("系统菜单 更新 Request DTO")
public class MenuUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单资源编号
     */
    @ApiModelProperty(value = "菜单资源编号")
    private Long id;
    /**
     * 菜单名
     */
    @ApiModelProperty(value = "菜单名")
    private String name;
    /**
     * 权限标识(多个用逗号分隔，如：user:list,user:create)
     */
    @ApiModelProperty(value = "权限标识(多个用逗号分隔，如：user:list,user:create)")
    private String permission;
    /**
     * 资源类型 0：目录   1：菜单   2：按钮
     */
    @ApiModelProperty(value = "资源类型 0：目录   1：菜单   2：按钮")
    private Integer type;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 父菜单ID，一级菜单为0
     */
    @ApiModelProperty(value = "父菜单ID，一级菜单为0")
    private Long parentId;
    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String icon;
    /**
     * 菜单URL
     */
    @ApiModelProperty(value = "菜单URL")
    private String url;
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
}