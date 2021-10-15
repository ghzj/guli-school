package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuListDTO;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuUpdateDTO;
import io.github.ghzj.guli.system.object.view.menu.MenuPageVO;
import io.github.ghzj.guli.system.object.view.menu.MenuInfoVO;
import io.github.ghzj.guli.system.rpc.MenuRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("系统菜单 API")
@RestController
@RequestMapping("system/menu")
public class MenuRpcController {

    @DubboReference(version = "1.0.0")
    private MenuRpc menuRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<MenuPageVO>> list(@RequestBody @Validated MenuListDTO param){
        CommonResult<PageUtils<MenuPageVO>> page = menuRpc.pageMenu(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询系统菜单信息")
    public CommonResult<MenuInfoVO> info(@PathVariable("id") Long id){
        CommonResult<MenuInfoVO> info = menuRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加系统菜单")
    public CommonResult<Boolean> save(@RequestBody MenuSaveDTO param){
        CommonResult<Boolean> save = menuRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新系统菜单")
    public CommonResult<Boolean> update(@RequestBody MenuUpdateDTO param){
        CommonResult<Boolean> update = menuRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除系统菜单")
    public CommonResult<Boolean> delete(@RequestBody Long[] ids){
        CommonResult<Boolean> delete = menuRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







