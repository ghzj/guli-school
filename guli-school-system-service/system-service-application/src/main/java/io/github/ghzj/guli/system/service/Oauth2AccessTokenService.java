package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.Oauth2AccessTokenEntity;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenListDTO;

import java.util.Map;

/**
 * 访问令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface Oauth2AccessTokenService extends IService<Oauth2AccessTokenEntity> {

    PageUtils<Oauth2AccessTokenEntity> queryPage(Oauth2AccessTokenListDTO params);
}