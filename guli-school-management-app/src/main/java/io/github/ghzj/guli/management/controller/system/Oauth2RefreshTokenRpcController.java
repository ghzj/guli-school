package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenUpdateDTO;
import io.github.ghzj.guli.system.object.view.oauth2.refresh.token.Oauth2RefreshTokenPageVO;
import io.github.ghzj.guli.system.object.view.oauth2.refresh.token.Oauth2RefreshTokenInfoVO;
import io.github.ghzj.guli.system.rpc.Oauth2RefreshTokenRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 刷新令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("刷新令牌 API")
@RestController
@RequestMapping("system/oauth2refreshtoken")
public class Oauth2RefreshTokenRpcController {

    @DubboReference(version = "1.0.0")
    private Oauth2RefreshTokenRpc oauth2RefreshTokenRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<Oauth2RefreshTokenPageVO>> list(@RequestBody @Validated Oauth2RefreshTokenListDTO param){
        CommonResult<PageUtils<Oauth2RefreshTokenPageVO>> page = oauth2RefreshTokenRpc.pageOauth2RefreshToken(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询刷新令牌信息")
    public CommonResult<Oauth2RefreshTokenInfoVO> info(@PathVariable("id") String id){
        CommonResult<Oauth2RefreshTokenInfoVO> info = oauth2RefreshTokenRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加刷新令牌")
    public CommonResult<Boolean> save(@RequestBody Oauth2RefreshTokenSaveDTO param){
        CommonResult<Boolean> save = oauth2RefreshTokenRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新刷新令牌")
    public CommonResult<Boolean> update(@RequestBody Oauth2RefreshTokenUpdateDTO param){
        CommonResult<Boolean> update = oauth2RefreshTokenRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除刷新令牌")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = oauth2RefreshTokenRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







