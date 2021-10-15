package io.github.ghzj.guli.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.entity.OssConfigEntity;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigListDTO;

import java.util.Map;

/**
 * 系统oss配置
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
public interface OssConfigService extends IService<OssConfigEntity> {

    PageUtils<OssConfigEntity> queryPage(OssConfigListDTO params);
}