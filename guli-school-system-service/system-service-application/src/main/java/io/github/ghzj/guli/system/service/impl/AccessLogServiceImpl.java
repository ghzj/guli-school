package io.github.ghzj.guli.system.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.system.dao.AccessLogDao;
import io.github.ghzj.guli.system.entity.AccessLogEntity;
import io.github.ghzj.guli.system.service.AccessLogService;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 系统访问日志
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Service("accessLogService")
public class AccessLogServiceImpl extends ServiceImpl<AccessLogDao, AccessLogEntity> implements AccessLogService {

    @Override
    public PageUtils<AccessLogEntity> queryPage(AccessLogListDTO params) {
        IPage<AccessLogEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<AccessLogEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}