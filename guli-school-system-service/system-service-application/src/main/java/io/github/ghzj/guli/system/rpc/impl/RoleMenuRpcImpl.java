package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.RoleMenuCodeConstants;
import io.github.ghzj.guli.system.convert.RoleMenuMapStruct;
import io.github.ghzj.guli.system.entity.RoleMenuEntity;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuListDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuUpdateDTO;
import io.github.ghzj.guli.system.object.view.role.menu.RoleMenuPageVO;
import io.github.ghzj.guli.system.object.view.role.menu.RoleMenuInfoVO;
import io.github.ghzj.guli.system.service.RoleMenuService;
import io.github.ghzj.guli.system.rpc.RoleMenuRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 角色菜单连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class RoleMenuRpcImpl implements RoleMenuRpc {

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public CommonResult<PageUtils<RoleMenuPageVO>> pageRoleMenu(RoleMenuListDTO param){
        PageUtils<RoleMenuEntity> page = roleMenuService.queryPage(param);

        return CommonResult.success(RoleMenuMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<RoleMenuInfoVO> info(Long id){
        RoleMenuEntity roleMenu = roleMenuService.getById(id);

        return CommonResult.success(RoleMenuMapStruct.INSTANCE.P2IV(roleMenu));
    }

    @Override
    public CommonResult<Boolean> save(RoleMenuSaveDTO param){
        boolean flag = roleMenuService.save(RoleMenuMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(RoleMenuCodeConstants.SYSTEM_ROLE_MENU_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(RoleMenuUpdateDTO param){
        boolean flag = roleMenuService.updateById(RoleMenuMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(RoleMenuCodeConstants.SYSTEM_ROLE_MENU_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(Long[] ids){
        boolean flag = roleMenuService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(RoleMenuCodeConstants.SYSTEM_ROLE_MENU_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}