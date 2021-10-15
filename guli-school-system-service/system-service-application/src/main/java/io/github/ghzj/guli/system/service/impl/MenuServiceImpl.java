package io.github.ghzj.guli.system.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.system.dao.MenuDao;
import io.github.ghzj.guli.system.entity.MenuEntity;
import io.github.ghzj.guli.system.service.MenuService;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService {

    @Override
    public PageUtils<MenuEntity> queryPage(MenuListDTO params) {
        IPage<MenuEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<MenuEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}