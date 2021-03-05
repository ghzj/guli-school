package io.github.ghzj.guli.education.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface VideoCodeConstants {

    ErrorCode EDUCATION_VIDEO_SAVE_ERROR = new ErrorCode(1000000000, "课程视频添加失败");
    ErrorCode EDUCATION_VIDEO_UPDATE_ERROR = new ErrorCode(1000000001, "课程视频更新失败");
    ErrorCode EDUCATION_VIDEO_DELETE_ERROR = new ErrorCode(1000000002, "课程视频删除失败");
}