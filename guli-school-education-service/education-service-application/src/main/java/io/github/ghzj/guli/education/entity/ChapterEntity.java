package io.github.ghzj.guli.education.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@TableName("education_chapter")
public class ChapterEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //章节ID
    @TableId
    private String id;
    //课程ID
    private String courseId;
    //章节名称
    private String title;
    //显示排序
    private Integer sort;
    //创建时间
    private Date gmtCreate;
    //更新时间
    private Date gmtModified;

}