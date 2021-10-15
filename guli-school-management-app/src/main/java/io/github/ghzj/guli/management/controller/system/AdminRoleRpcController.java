package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleListDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleUpdateDTO;
import io.github.ghzj.guli.system.object.view.admin.role.AdminRolePageVO;
import io.github.ghzj.guli.system.object.view.admin.role.AdminRoleInfoVO;
import io.github.ghzj.guli.system.rpc.AdminRoleRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 管理员角色连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("管理员角色连表 API")
@RestController
@RequestMapping("system/adminrole")
public class AdminRoleRpcController {

    @DubboReference(version = "1.0.0")
    private AdminRoleRpc adminRoleRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<AdminRolePageVO>> list(@RequestBody @Validated AdminRoleListDTO param){
        CommonResult<PageUtils<AdminRolePageVO>> page = adminRoleRpc.pageAdminRole(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询管理员角色连表信息")
    public CommonResult<AdminRoleInfoVO> info(@PathVariable("id") Long id){
        CommonResult<AdminRoleInfoVO> info = adminRoleRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加管理员角色连表")
    public CommonResult<Boolean> save(@RequestBody AdminRoleSaveDTO param){
        CommonResult<Boolean> save = adminRoleRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新管理员角色连表")
    public CommonResult<Boolean> update(@RequestBody AdminRoleUpdateDTO param){
        CommonResult<Boolean> update = adminRoleRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除管理员角色连表")
    public CommonResult<Boolean> delete(@RequestBody Long[] ids){
        CommonResult<Boolean> delete = adminRoleRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







