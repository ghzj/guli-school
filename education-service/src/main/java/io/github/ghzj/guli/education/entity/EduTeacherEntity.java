package io.github.ghzj.guli.education.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 讲师
 * 
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@Data
@TableName("edu_teacher")
public class EduTeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 讲师ID
	 */
	@TableId
	private String id;
	/**
	 * 讲师姓名
	 */
	private String name;
	/**
	 * 讲师简介
	 */
	private String intro;
	/**
	 * 讲师资历,一句话说明讲师
	 */
	private String career;
	/**
	 * 头衔 1高级讲师 2首席讲师
	 */
	private Integer level;
	/**
	 * 讲师头像
	 */
	private String avatar;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 逻辑删除 1（true）已删除， 0（false）未删除
	 */
	@TableLogic
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
