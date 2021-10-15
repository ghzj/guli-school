package io.github.ghzj.guli.system.object.view.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("系统用户 分页 Response VO")
public class AdminPageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 管理员编号
     */
    @ApiModelProperty(value = "管理员编号")
    private Long id;
    /**
     * 真实名字
     */
    @ApiModelProperty(value = "真实名字")
    private String name;
    /**
     * 登陆账号
     */
    @ApiModelProperty(value = "登陆账号")
    private String username;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;
    /**
     * 加密后的密码
     */
    @ApiModelProperty(value = "加密后的密码")
    private String password;
    /**
     * 密码的盐
     */
    @ApiModelProperty(value = "密码的盐")
    private String passwordSalt;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID")
    private Long createAdminId;
    /**
     * 创建 IP
     */
    @ApiModelProperty(value = "创建 IP")
    private String createIp;
    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date createTime;
    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间")
    private Date updateTime;
    /**
     * 状态  0：正常   1：禁用
     */
    @ApiModelProperty(value = "状态  0：正常   1：禁用")
    private Integer status;
}