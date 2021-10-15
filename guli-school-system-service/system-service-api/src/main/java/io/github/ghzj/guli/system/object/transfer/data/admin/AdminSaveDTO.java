package io.github.ghzj.guli.system.object.transfer.data.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("系统用户 添加 Request DTO")
public class AdminSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 真实名字
     */
    @ApiModelProperty(value = "真实名字",required = true)
    @NotBlank(message = "真实名字不能为空")
    @Length(max = 10, message = "真实名字长度最大为 10 位")
    private String name;
    /**
     * 登陆账号
     */
    @ApiModelProperty(value = "登陆账号",required = true)
    @NotBlank(message = "登陆账号不能为空")
    @Length(min = 5, max = 16, message = "账号长度为 5-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String username;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;
    /**
     * 加密后的密码
     */
    @ApiModelProperty(value = "密码",required = true)
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    @NotBlank(message = "登陆账号不能为空")
    private String password;

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
}