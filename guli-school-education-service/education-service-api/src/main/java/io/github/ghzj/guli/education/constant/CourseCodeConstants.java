package io.github.ghzj.guli.education.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface CourseCodeConstants {

    ErrorCode EDUCATION_COURSE_SAVE_ERROR = new ErrorCode(1000005000, "课程添加失败");
    ErrorCode EDUCATION_COURSE_UPDATE_ERROR = new ErrorCode(1000005001, "课程更新失败");
    ErrorCode EDUCATION_COURSE_DELETE_ERROR = new ErrorCode(1000005002, "课程删除失败");
}