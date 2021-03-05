package io.github.ghzj.guli.education.object.transfer.data.video;

import io.github.ghzj.guli.common.vo.OrderParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@ApiModel("课程视频 分页 Request DTO")
public class VideoListDTO extends OrderParam {
    //视频ID
    @ApiModelProperty(value = "视频ID")
    private String id;
    //课程ID
    @ApiModelProperty(value = "课程ID")
    private String courseId;
    //章节ID
    @ApiModelProperty(value = "章节ID")
    private String chapterId;
    //节点名称
    @ApiModelProperty(value = "节点名称")
    private String title;
    //云端视频资源
    @ApiModelProperty(value = "云端视频资源")
    private String videoSourceId;
    //原始文件名称
    @ApiModelProperty(value = "原始文件名称")
    private String videoOriginalName;
    //排序字段
    @ApiModelProperty(value = "排序字段")
    private Integer sort;
    //播放次数
    @ApiModelProperty(value = "播放次数")
    private Long playCount;
    //是否可以试听：0收费 1免费
    @ApiModelProperty(value = "是否可以试听：0收费 1免费")
    private Integer isFree;
    //视频时长（秒）
    @ApiModelProperty(value = "视频时长（秒）")
    private Float duration;
    //Empty未上传 Transcoding转码中  Normal正常
    @ApiModelProperty(value = "Empty未上传 Transcoding转码中  Normal正常")
    private String status;
    //视频源文件大小（字节）
    @ApiModelProperty(value = "视频源文件大小（字节）")
    private Long size;
    //乐观锁
    @ApiModelProperty(value = "乐观锁")
    private Long version;
    //创建时间
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    //更新时间
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
}