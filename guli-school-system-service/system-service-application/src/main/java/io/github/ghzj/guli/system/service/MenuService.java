package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.MenuEntity;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuListDTO;

import java.util.Map;

/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils<MenuEntity> queryPage(MenuListDTO params);
}