package io.github.ghzj.guli.education.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@TableName("education_course_description")
public class CourseDescriptionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //课程ID
    @TableId
    private String id;
    //课程简介
    private String description;
    //创建时间
    private Date gmtCreate;
    //更新时间
    private Date gmtModified;

}