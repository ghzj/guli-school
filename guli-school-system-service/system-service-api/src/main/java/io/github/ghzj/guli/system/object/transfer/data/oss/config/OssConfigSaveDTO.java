package io.github.ghzj.guli.system.object.transfer.data.oss.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 系统oss配置
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
@Data
@ApiModel("系统oss配置 添加 Request DTO")
public class OssConfigSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Long id;
    /**
     * 阿里云endpoint
     */
    @ApiModelProperty(value = "阿里云endpoint")
    private String aliyunEndpoint;
    /**
     * 阿里云bucket
     */
    @ApiModelProperty(value = "阿里云bucket")
    private String aliyunBucket;
    /**
     * 阿里云accessKey
     */
    @ApiModelProperty(value = "阿里云accessKey")
    private String aliyunAccessKey;
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