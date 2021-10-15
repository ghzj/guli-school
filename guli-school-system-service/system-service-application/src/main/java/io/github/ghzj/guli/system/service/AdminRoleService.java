package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.AdminRoleEntity;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleListDTO;

import java.util.Map;

/**
 * 管理员角色连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface AdminRoleService extends IService<AdminRoleEntity> {

    PageUtils<AdminRoleEntity> queryPage(AdminRoleListDTO params);
}