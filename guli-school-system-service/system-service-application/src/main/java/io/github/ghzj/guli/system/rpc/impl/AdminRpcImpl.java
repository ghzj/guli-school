package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.AdminCodeConstants;
import io.github.ghzj.guli.system.convert.AdminMapStruct;
import io.github.ghzj.guli.system.entity.AdminEntity;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminListDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminUpdateDTO;
import io.github.ghzj.guli.system.object.view.admin.AdminPageVO;
import io.github.ghzj.guli.system.object.view.admin.AdminInfoVO;
import io.github.ghzj.guli.system.service.AdminService;
import io.github.ghzj.guli.system.rpc.AdminRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class AdminRpcImpl implements AdminRpc {

    @Autowired
    private AdminService adminService;

    @Override
    public CommonResult<PageUtils<AdminPageVO>> pageAdmin(AdminListDTO param){
        PageUtils<AdminEntity> page = adminService.queryPage(param);

        return CommonResult.success(AdminMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<AdminInfoVO> info(Long id){
        AdminEntity admin = adminService.getById(id);

        return CommonResult.success(AdminMapStruct.INSTANCE.P2IV(admin));
    }

    @Override
    public CommonResult<Boolean> save(AdminSaveDTO param){
        return CommonResult.success(adminService.createAdmin(AdminMapStruct.INSTANCE.DTO2P(param)));
    }

    @Override
    public CommonResult<Boolean> update(AdminUpdateDTO param){
        boolean flag = adminService.updateById(AdminMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(AdminCodeConstants.SYSTEM_ADMIN_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(Long[] ids){
        boolean flag = adminService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(AdminCodeConstants.SYSTEM_ADMIN_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}