package io.github.ghzj.guli.system.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.system.constant.AccessLogCodeConstants;
import io.github.ghzj.guli.system.convert.AccessLogMapStruct;
import io.github.ghzj.guli.system.entity.AccessLogEntity;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogListDTO;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogUpdateDTO;
import io.github.ghzj.guli.system.object.view.access.log.AccessLogPageVO;
import io.github.ghzj.guli.system.object.view.access.log.AccessLogInfoVO;
import io.github.ghzj.guli.system.service.AccessLogService;
import io.github.ghzj.guli.system.rpc.AccessLogRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 系统访问日志
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@DubboService(version = "1.0.0")
public class AccessLogRpcImpl implements AccessLogRpc {

    @Autowired
    private AccessLogService accessLogService;

    @Override
    public CommonResult<PageUtils<AccessLogPageVO>> pageAccessLog(AccessLogListDTO param){
        PageUtils<AccessLogEntity> page = accessLogService.queryPage(param);

        return CommonResult.success(AccessLogMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<AccessLogInfoVO> info(Long id){
        AccessLogEntity accessLog = accessLogService.getById(id);

        return CommonResult.success(AccessLogMapStruct.INSTANCE.P2IV(accessLog));
    }

    @Override
    public CommonResult<Boolean> save(AccessLogSaveDTO param){
        boolean flag = accessLogService.save(AccessLogMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(AccessLogCodeConstants.SYSTEM_ACCESS_LOG_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(AccessLogUpdateDTO param){
        boolean flag = accessLogService.updateById(AccessLogMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(AccessLogCodeConstants.SYSTEM_ACCESS_LOG_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(Long[] ids){
        boolean flag = accessLogService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(AccessLogCodeConstants.SYSTEM_ACCESS_LOG_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}