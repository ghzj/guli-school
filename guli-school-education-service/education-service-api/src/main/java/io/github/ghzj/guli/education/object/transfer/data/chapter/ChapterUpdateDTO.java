package io.github.ghzj.guli.education.object.transfer.data.chapter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@ApiModel("课程 更新 Request DTO")
public class ChapterUpdateDTO {
    //章节ID
    @ApiModelProperty(value = "章节ID")
    private String id;
    //课程ID
    @ApiModelProperty(value = "课程ID")
    private String courseId;
    //章节名称
    @ApiModelProperty(value = "章节名称")
    private String title;
    //显示排序
    @ApiModelProperty(value = "显示排序")
    private Integer sort;
    //创建时间
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    //更新时间
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
}