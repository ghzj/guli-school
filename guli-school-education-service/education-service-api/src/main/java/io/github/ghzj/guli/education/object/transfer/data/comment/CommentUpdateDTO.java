package io.github.ghzj.guli.education.object.transfer.data.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
@Data
@ApiModel("评论 更新 Request DTO")
public class CommentUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 讲师ID
     */
    @ApiModelProperty(value = "讲师ID")
    private String id;
    /**
     * 课程id
     */
    @ApiModelProperty(value = "课程id")
    private String courseId;
    /**
     * 讲师id
     */
    @ApiModelProperty(value = "讲师id")
    private String teacherId;
    /**
     * 会员id
     */
    @ApiModelProperty(value = "会员id")
    private String memberId;
    /**
     * 会员昵称
     */
    @ApiModelProperty(value = "会员昵称")
    private String nickname;
    /**
     * 会员头像
     */
    @ApiModelProperty(value = "会员头像")
    private String avatar;
    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String content;
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