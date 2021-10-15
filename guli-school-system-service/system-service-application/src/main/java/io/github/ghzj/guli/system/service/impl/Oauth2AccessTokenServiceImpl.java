package io.github.ghzj.guli.system.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.system.dao.Oauth2AccessTokenDao;
import io.github.ghzj.guli.system.entity.Oauth2AccessTokenEntity;
import io.github.ghzj.guli.system.service.Oauth2AccessTokenService;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.access.token.Oauth2AccessTokenListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 访问令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Service("oauth2AccessTokenService")
public class Oauth2AccessTokenServiceImpl extends ServiceImpl<Oauth2AccessTokenDao, Oauth2AccessTokenEntity> implements Oauth2AccessTokenService {

    @Override
    public PageUtils<Oauth2AccessTokenEntity> queryPage(Oauth2AccessTokenListDTO params) {
        IPage<Oauth2AccessTokenEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<Oauth2AccessTokenEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}