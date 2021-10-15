package io.github.ghzj.guli.system.object.transfer.data.admin.role;

import io.github.ghzj.guli.common.vo.OrderParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 管理员角色连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("管理员角色连表 分页 Request DTO")
public class AdminRoleListDTO extends OrderParam {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Long id;
    /**
     * 管理员编号
     */
    @ApiModelProperty(value = "管理员编号")
    private Long adminId;
    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编号")
    private Long roleId;
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