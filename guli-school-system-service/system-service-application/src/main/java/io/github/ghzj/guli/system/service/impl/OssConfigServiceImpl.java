package io.github.ghzj.guli.system.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.system.dao.OssConfigDao;
import io.github.ghzj.guli.system.entity.OssConfigEntity;
import io.github.ghzj.guli.system.service.OssConfigService;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 系统oss配置
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Service("ossConfigService")
public class OssConfigServiceImpl extends ServiceImpl<OssConfigDao, OssConfigEntity> implements OssConfigService {

    @Override
    public PageUtils<OssConfigEntity> queryPage(OssConfigListDTO params) {
        IPage<OssConfigEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<OssConfigEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}