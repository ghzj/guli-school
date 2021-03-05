CREATE DATABASE `guli_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 系统用户
DROP TABLE IF EXISTS `system_admin`;
CREATE TABLE `system_admin` (
    `id`  bigint(19) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
    `name` varchar(10) NOT NULL COMMENT '真实名字',
    `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '登陆账号',
    `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '加密后的密码',
    `password_salt` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码的盐',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
    `create_admin_id` bigint(19) NOT NULL COMMENT '创建者ID',
    `create_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建 IP',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `status` tinyint(4) NOT NULL default 0 COMMENT '状态  0：正常   1：禁用',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_username` (`username`) USING BTREE
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='系统用户';

-- 系统菜单
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
    `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '菜单资源编号',
    `name` varchar(50) NOT NULL COMMENT '菜单名',
    `permission` varchar(255) DEFAULT NULL COMMENT '权限标识(多个用逗号分隔，如：user:list,user:create)',
    `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '资源类型 0：目录   1：菜单   2：按钮',
    `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
    `parent_id` bigint(19) NOT NULL DEFAULT '0' COMMENT '父菜单ID，一级菜单为0',
    `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
    `url` varchar(200)  DEFAULT NULL COMMENT '菜单URL',
    `create_admin_id` int(11) NOT NULL COMMENT '创建管理员编号',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='系统菜单';

-- 系统角色
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
    `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
    `name` varchar(50) NOT NULL COMMENT '角色名',
    `type` tinyint(4)  NOT NULL COMMENT '角色类型，0 系统角色，1 自定义角色',
    `create_admin_id` int(11)  NOT NULL COMMENT '创建管理员编号',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `remark` varchar(100) COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='系统角色';



-- 管理员角色连表
DROP TABLE IF EXISTS `system_admin_role`;
CREATE TABLE `system_admin_role` (
    `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `admin_id` bigint(19) NOT NULL COMMENT '管理员编号',
    `role_id` bigint(19) NOT NULL COMMENT '角色编号',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='管理员角色连表';

-- 角色菜单连表
DROP TABLE IF EXISTS `system_role_menu`;
CREATE TABLE `system_role_menu` (
    `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `role_id` bigint(19) NOT NULL  COMMENT '角色编号',
    `menu_id` bigint(19) NOT NULL  COMMENT '菜单编号',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='角色菜单连表';

-- 访问token
DROP TABLE IF EXISTS `system_oauth2_access_token`;
CREATE TABLE `system_oauth2_access_token` (
    `id` varchar(32) NOT NULL COMMENT '访问令牌',
    `user_id` bigint(19) NOT NULL COMMENT '用户编号',
    `user_type` tinyint(4) NOT NULL COMMENT '用户类型',
    `refresh_token` varchar(32) NOT NULL COMMENT '刷新令牌',
    `expires_time` datetime NOT NULL COMMENT '过期时间',
    `create_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建 IP',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `idx_userId` (`user_id`) USING BTREE,
    KEY `idx_refreshToken` (`refresh_token`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='访问令牌';

-- 刷新token
DROP TABLE IF EXISTS `system_oauth2_refresh_token`;
CREATE TABLE `system_oauth2_refresh_token` (
    `id` varchar(32) NOT NULL COMMENT '编号，刷新令牌',
    `user_id` bigint(19) NOT NULL COMMENT '用户编号',
    `user_type` tinyint(4) NOT NULL COMMENT '用户类型',
    `expires_time` datetime NOT NULL COMMENT '过期时间',
    `create_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建 IP',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `idx_userId` (`user_id`) USING BTREE
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='刷新令牌';


-- 系统日志
DROP TABLE IF EXISTS `system_access_log`;
CREATE TABLE `system_access_log` (
    `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id` bigint(19) DEFAULT NULL COMMENT '用户编号',
    `user_type` tinyint(4) DEFAULT NULL COMMENT '用户类型',
    `trace_id` varchar(64) DEFAULT NULL COMMENT '链路追踪编号',
    `application_name` varchar(50) NOT NULL COMMENT '应用名',
    `uri` varchar(4096) NOT NULL DEFAULT '' COMMENT '访问地址',
    `query_string` varchar(4096) NOT NULL DEFAULT '' COMMENT '参数',
    `method` varchar(50) NOT NULL DEFAULT '' COMMENT 'http 方法',
    `user_agent` varchar(1024) NOT NULL DEFAULT '' COMMENT 'userAgent',
    `ip` varchar(50) NOT NULL DEFAULT '' COMMENT 'ip',
    `start_time` datetime NOT NULL COMMENT '请求时间',
    `response_time` int(11) NOT NULL COMMENT '响应时长 -- 毫秒级',
    `error_code` int(11) NOT NULL COMMENT '错误码',
    `error_message` varchar(512) DEFAULT NULL COMMENT '错误提示',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='系统访问日志';



-- 系统oss配置
DROP TABLE IF EXISTS `system_oss_config`;
CREATE TABLE `system_oss_config` (
    `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `aliyun_endpoint` varchar(50) NOT NULL COMMENT '阿里云endpoint',
    `aliyun_bucket` varchar(50) NOT NULL COMMENT '阿里云bucket',
    `aliyun_access_key` varchar(50) NOT NULL COMMENT '阿里云accessKey',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT='系统oss配置';