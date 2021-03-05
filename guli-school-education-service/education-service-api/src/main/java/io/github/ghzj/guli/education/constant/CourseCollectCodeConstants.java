package io.github.ghzj.guli.education.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface CourseCollectCodeConstants {

    ErrorCode EDUCATION_COURSE_COLLECT_SAVE_ERROR = new ErrorCode(1000004000, "课程收藏添加失败");
    ErrorCode EDUCATION_COURSE_COLLECT_UPDATE_ERROR = new ErrorCode(1000004001, "课程收藏更新失败");
    ErrorCode EDUCATION_COURSE_COLLECT_DELETE_ERROR = new ErrorCode(1000004002, "课程收藏删除失败");
}