package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminListDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminUpdateDTO;
import io.github.ghzj.guli.system.object.view.admin.AdminPageVO;
import io.github.ghzj.guli.system.object.view.admin.AdminInfoVO;
import io.github.ghzj.guli.system.rpc.AdminRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("系统用户 API")
@RestController
@RequestMapping("system/admin")
public class AdminRpcController {

    @DubboReference(version = "1.0.0")
    private AdminRpc adminRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<AdminPageVO>> list(@RequestBody @Validated AdminListDTO param){
        CommonResult<PageUtils<AdminPageVO>> page = adminRpc.pageAdmin(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询系统用户信息")
    public CommonResult<AdminInfoVO> info(@PathVariable("id") Long id){
        CommonResult<AdminInfoVO> info = adminRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加系统用户")
    public CommonResult<Boolean> save(@RequestBody AdminSaveDTO param){
        CommonResult<Boolean> save = adminRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新系统用户")
    public CommonResult<Boolean> update(@RequestBody AdminUpdateDTO param){
        CommonResult<Boolean> update = adminRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除系统用户")
    public CommonResult<Boolean> delete(@RequestBody Long[] ids){
        CommonResult<Boolean> delete = adminRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







