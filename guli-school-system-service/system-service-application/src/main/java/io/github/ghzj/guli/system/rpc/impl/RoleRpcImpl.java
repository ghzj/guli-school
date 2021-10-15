package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.RoleCodeConstants;
import io.github.ghzj.guli.system.convert.RoleMapStruct;
import io.github.ghzj.guli.system.entity.RoleEntity;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleListDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleUpdateDTO;
import io.github.ghzj.guli.system.object.view.role.RolePageVO;
import io.github.ghzj.guli.system.object.view.role.RoleInfoVO;
import io.github.ghzj.guli.system.service.RoleService;
import io.github.ghzj.guli.system.rpc.RoleRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 系统角色
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class RoleRpcImpl implements RoleRpc {

    @Autowired
    private RoleService roleService;

    @Override
    public CommonResult<PageUtils<RolePageVO>> pageRole(RoleListDTO param){
        PageUtils<RoleEntity> page = roleService.queryPage(param);

        return CommonResult.success(RoleMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<RoleInfoVO> info(Long id){
        RoleEntity role = roleService.getById(id);

        return CommonResult.success(RoleMapStruct.INSTANCE.P2IV(role));
    }

    @Override
    public CommonResult<Boolean> save(RoleSaveDTO param){
        boolean flag = roleService.save(RoleMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(RoleCodeConstants.SYSTEM_ROLE_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(RoleUpdateDTO param){
        boolean flag = roleService.updateById(RoleMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(RoleCodeConstants.SYSTEM_ROLE_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(Long[] ids){
        boolean flag = roleService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(RoleCodeConstants.SYSTEM_ROLE_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}