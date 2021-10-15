package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 系统访问日志
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface AccessLogCodeConstants {

    ErrorCode SYSTEM_ACCESS_LOG_SAVE_ERROR = new ErrorCode(1001002000, "系统访问日志添加失败");
    ErrorCode SYSTEM_ACCESS_LOG_UPDATE_ERROR = new ErrorCode(1001002001, "系统访问日志更新失败");
    ErrorCode SYSTEM_ACCESS_LOG_DELETE_ERROR = new ErrorCode(1001002002, "系统访问日志删除失败");
}