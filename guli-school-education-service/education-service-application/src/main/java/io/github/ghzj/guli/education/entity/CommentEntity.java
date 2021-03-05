package io.github.ghzj.guli.education.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@TableName("education_comment")
public class CommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //讲师ID
    @TableId
    private String id;
    //课程id
    private String courseId;
    //讲师id
    private String teacherId;
    //会员id
    private String memberId;
    //会员昵称
    private String nickname;
    //会员头像
    private String avatar;
    //评论内容
    private String content;
    //逻辑删除 1（true）已删除， 0（false）未删除
    private Integer isDeleted;
    //创建时间
    private Date gmtCreate;
    //更新时间
    private Date gmtModified;

}