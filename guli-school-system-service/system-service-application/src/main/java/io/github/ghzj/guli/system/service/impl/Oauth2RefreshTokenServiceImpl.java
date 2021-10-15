package io.github.ghzj.guli.system.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.system.dao.Oauth2RefreshTokenDao;
import io.github.ghzj.guli.system.entity.Oauth2RefreshTokenEntity;
import io.github.ghzj.guli.system.service.Oauth2RefreshTokenService;
import io.github.ghzj.guli.system.object.transfer.data.oauth2.refresh.token.Oauth2RefreshTokenListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 刷新令牌
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Service("oauth2RefreshTokenService")
public class Oauth2RefreshTokenServiceImpl extends ServiceImpl<Oauth2RefreshTokenDao, Oauth2RefreshTokenEntity> implements Oauth2RefreshTokenService {

    @Override
    public PageUtils<Oauth2RefreshTokenEntity> queryPage(Oauth2RefreshTokenListDTO params) {
        IPage<Oauth2RefreshTokenEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<Oauth2RefreshTokenEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}