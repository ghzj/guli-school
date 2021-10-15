package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 刷新令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface Oauth2RefreshTokenCodeConstants {

    ErrorCode SYSTEM_OAUTH2_REFRESH_TOKEN_SAVE_ERROR = new ErrorCode(1001001000, "刷新令牌添加失败");
    ErrorCode SYSTEM_OAUTH2_REFRESH_TOKEN_UPDATE_ERROR = new ErrorCode(1001001001, "刷新令牌更新失败");
    ErrorCode SYSTEM_OAUTH2_REFRESH_TOKEN_DELETE_ERROR = new ErrorCode(1001001002, "刷新令牌删除失败");
}