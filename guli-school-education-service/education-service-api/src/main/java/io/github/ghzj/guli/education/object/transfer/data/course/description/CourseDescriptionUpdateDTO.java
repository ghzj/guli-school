package io.github.ghzj.guli.education.object.transfer.data.course.description;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@ApiModel("课程简介 更新 Request DTO")
public class CourseDescriptionUpdateDTO {
    //课程ID
    @ApiModelProperty(value = "课程ID")
    private String id;
    //课程简介
    @ApiModelProperty(value = "课程简介")
    private String description;
    //创建时间
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    //更新时间
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
}