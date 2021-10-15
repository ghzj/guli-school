package io.github.ghzj.guli.system.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigListDTO;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigUpdateDTO;
import io.github.ghzj.guli.system.object.view.oss.config.OssConfigPageVO;
import io.github.ghzj.guli.system.object.view.oss.config.OssConfigInfoVO;

/**
 * 系统oss配置 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface OssConfigRpc {

    /**
     * 系统oss配置 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<OssConfigPageVO>> pageOssConfig(OssConfigListDTO param);


    /**
     * 系统oss配置 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<OssConfigInfoVO> info(Long id);

    /**
     * 系统oss配置 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(OssConfigSaveDTO param);

    /**
     * 系统oss配置 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(OssConfigUpdateDTO param);

    /**
     * 系统oss配置 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(Long[] ids);

}