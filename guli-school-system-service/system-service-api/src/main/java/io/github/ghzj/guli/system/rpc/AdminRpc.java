package io.github.ghzj.guli.system.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminListDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminUpdateDTO;
import io.github.ghzj.guli.system.object.view.admin.AdminPageVO;
import io.github.ghzj.guli.system.object.view.admin.AdminInfoVO;

/**
 * 系统用户 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface AdminRpc {

    /**
     * 系统用户 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<AdminPageVO>> pageAdmin(AdminListDTO param);


    /**
     * 系统用户 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<AdminInfoVO> info(Long id);

    /**
     * 系统用户 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(AdminSaveDTO param);

    /**
     * 系统用户 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(AdminUpdateDTO param);

    /**
     * 系统用户 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(Long[] ids);

}