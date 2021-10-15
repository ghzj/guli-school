package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 访问令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface Oauth2AccessTokenCodeConstants {

    ErrorCode SYSTEM_OAUTH2_ACCESS_TOKEN_SAVE_ERROR = new ErrorCode(1001004000, "访问令牌添加失败");
    ErrorCode SYSTEM_OAUTH2_ACCESS_TOKEN_UPDATE_ERROR = new ErrorCode(1001004001, "访问令牌更新失败");
    ErrorCode SYSTEM_OAUTH2_ACCESS_TOKEN_DELETE_ERROR = new ErrorCode(1001004002, "访问令牌删除失败");
}