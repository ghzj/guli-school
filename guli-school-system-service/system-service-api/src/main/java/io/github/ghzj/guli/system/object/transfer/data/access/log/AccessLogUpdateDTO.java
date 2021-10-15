package io.github.ghzj.guli.system.object.transfer.data.access.log;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 系统访问日志
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("系统访问日志 更新 Request DTO")
public class AccessLogUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Long id;
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
     * 链路追踪编号
     */
    @ApiModelProperty(value = "链路追踪编号")
    private String traceId;
    /**
     * 应用名
     */
    @ApiModelProperty(value = "应用名")
    private String applicationName;
    /**
     * 访问地址
     */
    @ApiModelProperty(value = "访问地址")
    private String uri;
    /**
     * 参数
     */
    @ApiModelProperty(value = "参数")
    private String queryString;
    /**
     * http 方法
     */
    @ApiModelProperty(value = "http 方法")
    private String method;
    /**
     * userAgent
     */
    @ApiModelProperty(value = "userAgent")
    private String userAgent;
    /**
     * ip
     */
    @ApiModelProperty(value = "ip")
    private String ip;
    /**
     * 请求时间
     */
    @ApiModelProperty(value = "请求时间")
    private Date startTime;
    /**
     * 响应时长 -- 毫秒级
     */
    @ApiModelProperty(value = "响应时长 -- 毫秒级")
    private Integer responseTime;
    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码")
    private Integer errorCode;
    /**
     * 错误提示
     */
    @ApiModelProperty(value = "错误提示")
    private String errorMessage;
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
}