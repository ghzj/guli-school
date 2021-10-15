package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface MenuCodeConstants {

    ErrorCode SYSTEM_MENU_SAVE_ERROR = new ErrorCode(1001007000, "系统菜单添加失败");
    ErrorCode SYSTEM_MENU_UPDATE_ERROR = new ErrorCode(1001007001, "系统菜单更新失败");
    ErrorCode SYSTEM_MENU_DELETE_ERROR = new ErrorCode(1001007002, "系统菜单删除失败");
}