package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.OssConfigCodeConstants;
import io.github.ghzj.guli.system.convert.OssConfigMapStruct;
import io.github.ghzj.guli.system.entity.OssConfigEntity;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigUpdateDTO;
import io.github.ghzj.guli.system.object.view.oss.config.OssConfigPageVO;
import io.github.ghzj.guli.system.object.view.oss.config.OssConfigInfoVO;
import io.github.ghzj.guli.system.service.OssConfigService;
import io.github.ghzj.guli.system.rpc.OssConfigRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 系统oss配置
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class OssConfigRpcImpl implements OssConfigRpc {

    @Autowired
    private OssConfigService ossConfigService;

    @Override
    public CommonResult<PageUtils<OssConfigPageVO>> pageOssConfig(OssConfigListDTO param){
        PageUtils<OssConfigEntity> page = ossConfigService.queryPage(param);

        return CommonResult.success(OssConfigMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<OssConfigInfoVO> info(Long id){
        OssConfigEntity ossConfig = ossConfigService.getById(id);

        return CommonResult.success(OssConfigMapStruct.INSTANCE.P2IV(ossConfig));
    }

    @Override
    public CommonResult<Boolean> save(OssConfigSaveDTO param){
        boolean flag = ossConfigService.save(OssConfigMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(OssConfigCodeConstants.SYSTEM_OSS_CONFIG_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(OssConfigUpdateDTO param){
        boolean flag = ossConfigService.updateById(OssConfigMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(OssConfigCodeConstants.SYSTEM_OSS_CONFIG_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(Long[] ids){
        boolean flag = ossConfigService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(OssConfigCodeConstants.SYSTEM_OSS_CONFIG_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}