package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.Oauth2RefreshTokenCodeConstants;
import io.github.ghzj.guli.system.convert.Oauth2RefreshTokenMapStruct;
import io.github.ghzj.guli.system.entity.Oauth2RefreshTokenEntity;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenUpdateDTO;
import io.github.ghzj.guli.system.object.view.oauth2.refresh.token.Oauth2RefreshTokenPageVO;
import io.github.ghzj.guli.system.object.view.oauth2.refresh.token.Oauth2RefreshTokenInfoVO;
import io.github.ghzj.guli.system.service.Oauth2RefreshTokenService;
import io.github.ghzj.guli.system.rpc.Oauth2RefreshTokenRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 刷新令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class Oauth2RefreshTokenRpcImpl implements Oauth2RefreshTokenRpc {

    @Autowired
    private Oauth2RefreshTokenService oauth2RefreshTokenService;

    @Override
    public CommonResult<PageUtils<Oauth2RefreshTokenPageVO>> pageOauth2RefreshToken(Oauth2RefreshTokenListDTO param){
        PageUtils<Oauth2RefreshTokenEntity> page = oauth2RefreshTokenService.queryPage(param);

        return CommonResult.success(Oauth2RefreshTokenMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<Oauth2RefreshTokenInfoVO> info(String id){
        Oauth2RefreshTokenEntity oauth2RefreshToken = oauth2RefreshTokenService.getById(id);

        return CommonResult.success(Oauth2RefreshTokenMapStruct.INSTANCE.P2IV(oauth2RefreshToken));
    }

    @Override
    public CommonResult<Boolean> save(Oauth2RefreshTokenSaveDTO param){
        boolean flag = oauth2RefreshTokenService.save(Oauth2RefreshTokenMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(Oauth2RefreshTokenCodeConstants.SYSTEM_OAUTH2_REFRESH_TOKEN_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(Oauth2RefreshTokenUpdateDTO param){
        boolean flag = oauth2RefreshTokenService.updateById(Oauth2RefreshTokenMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(Oauth2RefreshTokenCodeConstants.SYSTEM_OAUTH2_REFRESH_TOKEN_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = oauth2RefreshTokenService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(Oauth2RefreshTokenCodeConstants.SYSTEM_OAUTH2_REFRESH_TOKEN_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}