package io.github.ghzj.guli.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统访问日志
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Data
@TableName("system_access_log")
public class AccessLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 链路追踪编号
     */
    private String traceId;
    /**
     * 应用名
     */
    private String applicationName;
    /**
     * 访问地址
     */
    private String uri;
    /**
     * 参数
     */
    private String queryString;
    /**
     * http 方法
     */
    private String method;
    /**
     * userAgent
     */
    private String userAgent;
    /**
     * ip
     */
    private String ip;
    /**
     * 请求时间
     */
    private Date startTime;
    /**
     * 响应时长 -- 毫秒级
     */
    private Integer responseTime;
    /**
     * 错误码
     */
    private Integer errorCode;
    /**
     * 错误提示
     */
    private String errorMessage;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date updateTime;

}