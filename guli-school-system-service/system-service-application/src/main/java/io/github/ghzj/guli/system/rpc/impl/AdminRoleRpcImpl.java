package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.AdminRoleCodeConstants;
import io.github.ghzj.guli.system.convert.AdminRoleMapStruct;
import io.github.ghzj.guli.system.entity.AdminRoleEntity;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleListDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleUpdateDTO;
import io.github.ghzj.guli.system.object.view.admin.role.AdminRolePageVO;
import io.github.ghzj.guli.system.object.view.admin.role.AdminRoleInfoVO;
import io.github.ghzj.guli.system.service.AdminRoleService;
import io.github.ghzj.guli.system.rpc.AdminRoleRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 管理员角色连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class AdminRoleRpcImpl implements AdminRoleRpc {

    @Autowired
    private AdminRoleService adminRoleService;

    @Override
    public CommonResult<PageUtils<AdminRolePageVO>> pageAdminRole(AdminRoleListDTO param){
        PageUtils<AdminRoleEntity> page = adminRoleService.queryPage(param);

        return CommonResult.success(AdminRoleMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<AdminRoleInfoVO> info(Long id){
        AdminRoleEntity adminRole = adminRoleService.getById(id);

        return CommonResult.success(AdminRoleMapStruct.INSTANCE.P2IV(adminRole));
    }

    @Override
    public CommonResult<Boolean> save(AdminRoleSaveDTO param){
        boolean flag = adminRoleService.save(AdminRoleMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(AdminRoleCodeConstants.SYSTEM_ADMIN_ROLE_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(AdminRoleUpdateDTO param){
        boolean flag = adminRoleService.updateById(AdminRoleMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(AdminRoleCodeConstants.SYSTEM_ADMIN_ROLE_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(Long[] ids){
        boolean flag = adminRoleService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(AdminRoleCodeConstants.SYSTEM_ADMIN_ROLE_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}