package io.github.ghzj.guli.education.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程收藏
 * 
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@Data
@TableName("edu_course_collect")
public class EduCourseCollectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 收藏ID
	 */
	@TableId
	private String id;
	/**
	 * 课程讲师ID
	 */
	private String courseId;
	/**
	 * 课程专业ID
	 */
	private String memberId;
	/**
	 * 逻辑删除 1（true）已删除， 0（false）未删除
	 */
	private Integer isDeleted;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 更新时间
	 */
	private Date gmtModified;

}
