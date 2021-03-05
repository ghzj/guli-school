package io.github.ghzj.guli.education.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface CommentCodeConstants {

    ErrorCode EDUCATION_COMMENT_SAVE_ERROR = new ErrorCode(1000006000, "评论添加失败");
    ErrorCode EDUCATION_COMMENT_UPDATE_ERROR = new ErrorCode(1000006001, "评论更新失败");
    ErrorCode EDUCATION_COMMENT_DELETE_ERROR = new ErrorCode(1000006002, "评论删除失败");
}