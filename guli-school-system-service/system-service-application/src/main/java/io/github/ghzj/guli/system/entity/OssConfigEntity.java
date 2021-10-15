package io.github.ghzj.guli.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统oss配置
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Data
@TableName("system_oss_config")
public class OssConfigEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 阿里云endpoint
     */
    private String aliyunEndpoint;
    /**
     * 阿里云bucket
     */
    private String aliyunBucket;
    /**
     * 阿里云accessKey
     */
    private String aliyunAccessKey;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后更新时间
     */
    private Date updateTime;

}