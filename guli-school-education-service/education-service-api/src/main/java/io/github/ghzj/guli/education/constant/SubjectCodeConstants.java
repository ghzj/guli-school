package io.github.ghzj.guli.education.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface SubjectCodeConstants {

    ErrorCode EDUCATION_SUBJECT_SAVE_ERROR = new ErrorCode(1000003000, "课程科目添加失败");
    ErrorCode EDUCATION_SUBJECT_UPDATE_ERROR = new ErrorCode(1000003001, "课程科目更新失败");
    ErrorCode EDUCATION_SUBJECT_DELETE_ERROR = new ErrorCode(1000003002, "课程科目删除失败");
}