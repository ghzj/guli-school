package io.github.ghzj.guli.system.dao;

import io.github.ghzj.guli.system.entity.Oauth2RefreshTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 刷新令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface Oauth2RefreshTokenDao extends BaseMapper<Oauth2RefreshTokenEntity> {

}