package io.github.ghzj.guli.education.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface TeacherCodeConstants {

    ErrorCode EDUCATION_TEACHER_SAVE_ERROR = new ErrorCode(1000002000, "讲师添加失败");
    ErrorCode EDUCATION_TEACHER_UPDATE_ERROR = new ErrorCode(1000002001, "讲师更新失败");
    ErrorCode EDUCATION_TEACHER_DELETE_ERROR = new ErrorCode(1000002002, "讲师删除失败");
}