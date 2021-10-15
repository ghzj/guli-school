package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.Oauth2AccessTokenCodeConstants;
import io.github.ghzj.guli.system.convert.Oauth2AccessTokenMapStruct;
import io.github.ghzj.guli.system.entity.Oauth2AccessTokenEntity;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenUpdateDTO;
import io.github.ghzj.guli.system.object.view.oauth2.access.token.Oauth2AccessTokenPageVO;
import io.github.ghzj.guli.system.object.view.oauth2.access.token.Oauth2AccessTokenInfoVO;
import io.github.ghzj.guli.system.service.Oauth2AccessTokenService;
import io.github.ghzj.guli.system.rpc.Oauth2AccessTokenRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 访问令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class Oauth2AccessTokenRpcImpl implements Oauth2AccessTokenRpc {

    @Autowired
    private Oauth2AccessTokenService oauth2AccessTokenService;

    @Override
    public CommonResult<PageUtils<Oauth2AccessTokenPageVO>> pageOauth2AccessToken(Oauth2AccessTokenListDTO param){
        PageUtils<Oauth2AccessTokenEntity> page = oauth2AccessTokenService.queryPage(param);

        return CommonResult.success(Oauth2AccessTokenMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<Oauth2AccessTokenInfoVO> info(String id){
        Oauth2AccessTokenEntity oauth2AccessToken = oauth2AccessTokenService.getById(id);

        return CommonResult.success(Oauth2AccessTokenMapStruct.INSTANCE.P2IV(oauth2AccessToken));
    }

    @Override
    public CommonResult<Boolean> save(Oauth2AccessTokenSaveDTO param){
        boolean flag = oauth2AccessTokenService.save(Oauth2AccessTokenMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(Oauth2AccessTokenCodeConstants.SYSTEM_OAUTH2_ACCESS_TOKEN_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(Oauth2AccessTokenUpdateDTO param){
        boolean flag = oauth2AccessTokenService.updateById(Oauth2AccessTokenMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(Oauth2AccessTokenCodeConstants.SYSTEM_OAUTH2_ACCESS_TOKEN_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = oauth2AccessTokenService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(Oauth2AccessTokenCodeConstants.SYSTEM_OAUTH2_ACCESS_TOKEN_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}