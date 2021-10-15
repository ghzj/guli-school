package io.github.ghzj.guli.system.dao;

import io.github.ghzj.guli.system.entity.Oauth2AccessTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 访问令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface Oauth2AccessTokenDao extends BaseMapper<Oauth2AccessTokenEntity> {

}