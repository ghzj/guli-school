package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.MenuCodeConstants;
import io.github.ghzj.guli.system.convert.MenuMapStruct;
import io.github.ghzj.guli.system.entity.MenuEntity;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuListDTO;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuUpdateDTO;
import io.github.ghzj.guli.system.object.view.menu.MenuPageVO;
import io.github.ghzj.guli.system.object.view.menu.MenuInfoVO;
import io.github.ghzj.guli.system.service.MenuService;
import io.github.ghzj.guli.system.rpc.MenuRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class MenuRpcImpl implements MenuRpc {

    @Autowired
    private MenuService menuService;

    @Override
    public CommonResult<PageUtils<MenuPageVO>> pageMenu(MenuListDTO param){
        PageUtils<MenuEntity> page = menuService.queryPage(param);

        return CommonResult.success(MenuMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<MenuInfoVO> info(Long id){
        MenuEntity menu = menuService.getById(id);

        return CommonResult.success(MenuMapStruct.INSTANCE.P2IV(menu));
    }

    @Override
    public CommonResult<Boolean> save(MenuSaveDTO param){
        boolean flag = menuService.save(MenuMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(MenuCodeConstants.SYSTEM_MENU_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(MenuUpdateDTO param){
        boolean flag = menuService.updateById(MenuMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(MenuCodeConstants.SYSTEM_MENU_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(Long[] ids){
        boolean flag = menuService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(MenuCodeConstants.SYSTEM_MENU_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}