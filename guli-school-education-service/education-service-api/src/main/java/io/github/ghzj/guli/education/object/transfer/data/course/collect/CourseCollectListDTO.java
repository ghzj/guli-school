package io.github.ghzj.guli.education.object.transfer.data.course.collect;

import io.github.ghzj.guli.common.vo.OrderParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@ApiModel("课程收藏 分页 Request DTO")
public class CourseCollectListDTO extends OrderParam {
    //收藏ID
    @ApiModelProperty(value = "收藏ID")
    private String id;
    //课程讲师ID
    @ApiModelProperty(value = "课程讲师ID")
    private String courseId;
    //课程专业ID
    @ApiModelProperty(value = "课程专业ID")
    private String memberId;
    //逻辑删除 1（true）已删除， 0（false）未删除
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;
    //创建时间
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    //更新时间
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
}