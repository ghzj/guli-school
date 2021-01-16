package io.github.ghzj.guli.education.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * @author ghzj
 * @date 2021/1/12 21:25
 */
public interface EducationCodeConstants {
    ErrorCode EDUCATION_TEACHER_SAVE_ERROR = new ErrorCode(1001001200, "老师添加失败");
    ErrorCode EDUCATION_TEACHER_UPDATE_ERROR = new ErrorCode(1001001200, "老师更新失败");
}
