package io.github.ghzj.guli.system.constant;

import io.github.ghzj.guli.common.exception.ErrorCode;

/**
 * 系统oss配置
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface OssConfigCodeConstants {

    ErrorCode SYSTEM_OSS_CONFIG_SAVE_ERROR = new ErrorCode(1001000000, "系统oss配置添加失败");
    ErrorCode SYSTEM_OSS_CONFIG_UPDATE_ERROR = new ErrorCode(1001000001, "系统oss配置更新失败");
    ErrorCode SYSTEM_OSS_CONFIG_DELETE_ERROR = new ErrorCode(1001000002, "系统oss配置删除失败");
}