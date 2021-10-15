package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.Oauth2RefreshTokenEntity;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenListDTO;

import java.util.Map;

/**
 * 刷新令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface Oauth2RefreshTokenService extends IService<Oauth2RefreshTokenEntity> {

    PageUtils<Oauth2RefreshTokenEntity> queryPage(Oauth2RefreshTokenListDTO params);
}