package io.github.ghzj.guli.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Data
@TableName("system_admin")
public class AdminEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 管理员编号
     */
    @TableId
    private Long id;
    /**
     * 真实名字
     */
    private String name;
    /**
     * 登陆账号
     */
    private String username;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 加密后的密码
     */
    private String password;
    /**
     * 密码的盐
     */
    private String passwordSalt;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 创建者ID
     */
    private Long createAdminId;
    /**
     * 创建 IP
     */
    private String createIp;
    /**
     * 添加时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date updateTime;
    /**
     * 状态  0：正常   1：禁用
     */
    @TableLogic
    private Integer status;

}