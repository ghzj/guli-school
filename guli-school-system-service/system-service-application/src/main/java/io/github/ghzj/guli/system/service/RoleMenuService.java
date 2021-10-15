package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.RoleMenuEntity;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuListDTO;

import java.util.Map;

/**
 * 角色菜单连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface RoleMenuService extends IService<RoleMenuEntity> {

    PageUtils<RoleMenuEntity> queryPage(RoleMenuListDTO params);
}