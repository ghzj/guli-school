package io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 刷新令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("刷新令牌 添加 Request DTO")
public class Oauth2RefreshTokenSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号，刷新令牌
     */
    @ApiModelProperty(value = "编号，刷新令牌")
    private String id;
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    private Long userId;
    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    private Integer userType;
    /**
     * 过期时间
     */
    @ApiModelProperty(value = "过期时间")
    private Date expiresTime;
    /**
     * 创建 IP
     */
    @ApiModelProperty(value = "创建 IP")
    private String createIp;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间")
    private Date updateTime;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer deleted;
}