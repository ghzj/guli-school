package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.AccessLogEntity;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogListDTO;

import java.util.Map;

/**
 * 系统访问日志
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface AccessLogService extends IService<AccessLogEntity> {

    PageUtils<AccessLogEntity> queryPage(AccessLogListDTO params);
}