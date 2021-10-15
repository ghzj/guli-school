package io.github.ghzj.guli.education.object.transfer.data.course.collect;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Data
@ApiModel("课程收藏 添加 Request DTO")
public class CourseCollectSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 收藏ID
     */
    @ApiModelProperty(value = "收藏ID")
    private String id;
    /**
     * 课程讲师ID
     */
    @ApiModelProperty(value = "课程讲师ID")
    private String courseId;
    /**
     * 课程专业ID
     */
    @ApiModelProperty(value = "课程专业ID")
    private String memberId;
    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer deleted;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
}