package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigUpdateDTO;
import io.github.ghzj.guli.system.object.view.oss.config.OssConfigPageVO;
import io.github.ghzj.guli.system.object.view.oss.config.OssConfigInfoVO;
import io.github.ghzj.guli.system.rpc.OssConfigRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 系统oss配置
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("系统oss配置 API")
@RestController
@RequestMapping("system/ossconfig")
public class OssConfigRpcController {

    @DubboReference(version = "1.0.0")
    private OssConfigRpc ossConfigRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<OssConfigPageVO>> list(@RequestBody @Validated OssConfigListDTO param){
        CommonResult<PageUtils<OssConfigPageVO>> page = ossConfigRpc.pageOssConfig(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询系统oss配置信息")
    public CommonResult<OssConfigInfoVO> info(@PathVariable("id") Long id){
        CommonResult<OssConfigInfoVO> info = ossConfigRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加系统oss配置")
    public CommonResult<Boolean> save(@RequestBody OssConfigSaveDTO param){
        CommonResult<Boolean> save = ossConfigRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新系统oss配置")
    public CommonResult<Boolean> update(@RequestBody OssConfigUpdateDTO param){
        CommonResult<Boolean> update = ossConfigRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除系统oss配置")
    public CommonResult<Boolean> delete(@RequestBody Long[] ids){
        CommonResult<Boolean> delete = ossConfigRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







