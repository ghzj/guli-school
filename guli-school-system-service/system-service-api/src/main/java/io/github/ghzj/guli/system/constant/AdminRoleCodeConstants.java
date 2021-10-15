package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 管理员角色连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface AdminRoleCodeConstants {

    ErrorCode SYSTEM_ADMIN_ROLE_SAVE_ERROR = new ErrorCode(1001005000, "管理员角色连表添加失败");
    ErrorCode SYSTEM_ADMIN_ROLE_UPDATE_ERROR = new ErrorCode(1001005001, "管理员角色连表更新失败");
    ErrorCode SYSTEM_ADMIN_ROLE_DELETE_ERROR = new ErrorCode(1001005002, "管理员角色连表删除失败");
}