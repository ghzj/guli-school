package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.RoleEntity;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleListDTO;

import java.util.Map;

/**
 * 系统角色
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface RoleService extends IService<RoleEntity> {

    PageUtils<RoleEntity> queryPage(RoleListDTO params);
}