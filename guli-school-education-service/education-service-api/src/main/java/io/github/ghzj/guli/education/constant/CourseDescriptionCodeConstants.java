package io.github.ghzj.guli.education.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface CourseDescriptionCodeConstants {

    ErrorCode EDUCATION_COURSE_DESCRIPTION_SAVE_ERROR = new ErrorCode(1000001000, "课程简介添加失败");
    ErrorCode EDUCATION_COURSE_DESCRIPTION_UPDATE_ERROR = new ErrorCode(1000001001, "课程简介更新失败");
    ErrorCode EDUCATION_COURSE_DESCRIPTION_DELETE_ERROR = new ErrorCode(1000001002, "课程简介删除失败");
}