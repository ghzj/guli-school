package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 系统角色
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface RoleCodeConstants {

    ErrorCode SYSTEM_ROLE_SAVE_ERROR = new ErrorCode(1001006000, "系统角色添加失败");
    ErrorCode SYSTEM_ROLE_UPDATE_ERROR = new ErrorCode(1001006001, "系统角色更新失败");
    ErrorCode SYSTEM_ROLE_DELETE_ERROR = new ErrorCode(1001006002, "系统角色删除失败");
}