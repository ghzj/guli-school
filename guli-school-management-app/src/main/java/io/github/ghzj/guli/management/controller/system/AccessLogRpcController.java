package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogListDTO;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogUpdateDTO;
import io.github.ghzj.guli.system.object.view.access.log.AccessLogPageVO;
import io.github.ghzj.guli.system.object.view.access.log.AccessLogInfoVO;
import io.github.ghzj.guli.system.rpc.AccessLogRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 系统访问日志
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("系统访问日志 API")
@RestController
@RequestMapping("system/accesslog")
public class AccessLogRpcController {

    @DubboReference(version = "1.0.0")
    private AccessLogRpc accessLogRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<AccessLogPageVO>> list(@RequestBody @Validated AccessLogListDTO param){
        CommonResult<PageUtils<AccessLogPageVO>> page = accessLogRpc.pageAccessLog(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询系统访问日志信息")
    public CommonResult<AccessLogInfoVO> info(@PathVariable("id") Long id){
        CommonResult<AccessLogInfoVO> info = accessLogRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加系统访问日志")
    public CommonResult<Boolean> save(@RequestBody AccessLogSaveDTO param){
        CommonResult<Boolean> save = accessLogRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新系统访问日志")
    public CommonResult<Boolean> update(@RequestBody AccessLogUpdateDTO param){
        CommonResult<Boolean> update = accessLogRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除系统访问日志")
    public CommonResult<Boolean> delete(@RequestBody Long[] ids){
        CommonResult<Boolean> delete = accessLogRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







