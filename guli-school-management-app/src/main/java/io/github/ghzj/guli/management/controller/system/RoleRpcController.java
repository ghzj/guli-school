package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleListDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleUpdateDTO;
import io.github.ghzj.guli.system.object.view.role.RolePageVO;
import io.github.ghzj.guli.system.object.view.role.RoleInfoVO;
import io.github.ghzj.guli.system.rpc.RoleRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 系统角色
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("系统角色 API")
@RestController
@RequestMapping("system/role")
public class RoleRpcController {

    @DubboReference(version = "1.0.0")
    private RoleRpc roleRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<RolePageVO>> list(@RequestBody @Validated RoleListDTO param){
        CommonResult<PageUtils<RolePageVO>> page = roleRpc.pageRole(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询系统角色信息")
    public CommonResult<RoleInfoVO> info(@PathVariable("id") Long id){
        CommonResult<RoleInfoVO> info = roleRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加系统角色")
    public CommonResult<Boolean> save(@RequestBody RoleSaveDTO param){
        CommonResult<Boolean> save = roleRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新系统角色")
    public CommonResult<Boolean> update(@RequestBody RoleUpdateDTO param){
        CommonResult<Boolean> update = roleRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除系统角色")
    public CommonResult<Boolean> delete(@RequestBody Long[] ids){
        CommonResult<Boolean> delete = roleRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







