package io.github.ghzj.guli.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 访问令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Data
@TableName("system_oauth2_access_token")
public class Oauth2AccessTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 访问令牌
     */
    @TableId
    private String id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 过期时间
     */
    private Date expiresTime;
    /**
     * 创建 IP
     */
    private String createIp;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer deleted;

}