package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 角色菜单连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface RoleMenuCodeConstants {

    ErrorCode SYSTEM_ROLE_MENU_SAVE_ERROR = new ErrorCode(1001003000, "角色菜单连表添加失败");
    ErrorCode SYSTEM_ROLE_MENU_UPDATE_ERROR = new ErrorCode(1001003001, "角色菜单连表更新失败");
    ErrorCode SYSTEM_ROLE_MENU_DELETE_ERROR = new ErrorCode(1001003002, "角色菜单连表删除失败");
}