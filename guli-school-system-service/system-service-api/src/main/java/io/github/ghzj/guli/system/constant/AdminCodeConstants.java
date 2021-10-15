package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface AdminCodeConstants {

    ErrorCode SYSTEM_ADMIN_SAVE_ERROR = new ErrorCode(1001008000, "系统用户添加失败");
    ErrorCode SYSTEM_ADMIN_UPDATE_ERROR = new ErrorCode(1001008001, "系统用户更新失败");
    ErrorCode SYSTEM_ADMIN_DELETE_ERROR = new ErrorCode(1001008002, "系统用户删除失败");

    ErrorCode SYSTEM_ADMIN_USER_EXISTS = new ErrorCode(1001008003, "系统账号已存在");
}