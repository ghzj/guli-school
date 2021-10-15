package io.github.ghzj.guli.system.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogListDTO;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogUpdateDTO;
import io.github.ghzj.guli.system.object.view.access.log.AccessLogPageVO;
import io.github.ghzj.guli.system.object.view.access.log.AccessLogInfoVO;

/**
 * 系统访问日志 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface AccessLogRpc {

    /**
     * 系统访问日志 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<AccessLogPageVO>> pageAccessLog(AccessLogListDTO param);


    /**
     * 系统访问日志 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<AccessLogInfoVO> info(Long id);

    /**
     * 系统访问日志 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(AccessLogSaveDTO param);

    /**
     * 系统访问日志 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(AccessLogUpdateDTO param);

    /**
     * 系统访问日志 删除
     * @param ids id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(Long[] ids);

}