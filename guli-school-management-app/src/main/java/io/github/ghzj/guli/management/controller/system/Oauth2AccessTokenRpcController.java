package io.github.ghzj.guli.management.controller.system;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenUpdateDTO;
import io.github.ghzj.guli.system.object.view.oauth2.access.token.Oauth2AccessTokenPageVO;
import io.github.ghzj.guli.system.object.view.oauth2.access.token.Oauth2AccessTokenInfoVO;
import io.github.ghzj.guli.system.rpc.Oauth2AccessTokenRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 访问令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 01:49:15
 */
@Api("访问令牌 API")
@RestController
@RequestMapping("system/oauth2accesstoken")
public class Oauth2AccessTokenRpcController {

    @DubboReference(version = "1.0.0")
    private Oauth2AccessTokenRpc oauth2AccessTokenRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<Oauth2AccessTokenPageVO>> list(@RequestBody @Validated Oauth2AccessTokenListDTO param){
        CommonResult<PageUtils<Oauth2AccessTokenPageVO>> page = oauth2AccessTokenRpc.pageOauth2AccessToken(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询访问令牌信息")
    public CommonResult<Oauth2AccessTokenInfoVO> info(@PathVariable("id") String id){
        CommonResult<Oauth2AccessTokenInfoVO> info = oauth2AccessTokenRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加访问令牌")
    public CommonResult<Boolean> save(@RequestBody Oauth2AccessTokenSaveDTO param){
        CommonResult<Boolean> save = oauth2AccessTokenRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新访问令牌")
    public CommonResult<Boolean> update(@RequestBody Oauth2AccessTokenUpdateDTO param){
        CommonResult<Boolean> update = oauth2AccessTokenRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除访问令牌")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = oauth2AccessTokenRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







