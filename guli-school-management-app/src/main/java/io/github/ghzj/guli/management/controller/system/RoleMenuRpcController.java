package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuListDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuUpdateDTO;
import io.github.ghzj.guli.system.object.view.role.menu.RoleMenuPageVO;
import io.github.ghzj.guli.system.object.view.role.menu.RoleMenuInfoVO;
import io.github.ghzj.guli.system.rpc.RoleMenuRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 角色菜单连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("角色菜单连表 API")
@RestController
@RequestMapping("system/rolemenu")
public class RoleMenuRpcController {

    @DubboReference(version = "1.0.0")
    private RoleMenuRpc roleMenuRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<RoleMenuPageVO>> list(@RequestBody @Validated RoleMenuListDTO param){
        CommonResult<PageUtils<RoleMenuPageVO>> page = roleMenuRpc.pageRoleMenu(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询角色菜单连表信息")
    public CommonResult<RoleMenuInfoVO> info(@PathVariable("id") Long id){
        CommonResult<RoleMenuInfoVO> info = roleMenuRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加角色菜单连表")
    public CommonResult<Boolean> save(@RequestBody RoleMenuSaveDTO param){
        CommonResult<Boolean> save = roleMenuRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新角色菜单连表")
    public CommonResult<Boolean> update(@RequestBody RoleMenuUpdateDTO param){
        CommonResult<Boolean> update = roleMenuRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除角色菜单连表")
    public CommonResult<Boolean> delete(@RequestBody Long[] ids){
        CommonResult<Boolean> delete = roleMenuRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







