package io.github.ghzj.guli.system.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleListDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleUpdateDTO;
import io.github.ghzj.guli.system.object.view.admin.role.AdminRolePageVO;
import io.github.ghzj.guli.system.object.view.admin.role.AdminRoleInfoVO;

/**
 * 管理员角色连表 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface AdminRoleRpc {

    /**
     * 管理员角色连表 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<AdminRolePageVO>> pageAdminRole(AdminRoleListDTO param);


    /**
     * 管理员角色连表 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<AdminRoleInfoVO> info(Long id);

    /**
     * 管理员角色连表 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(AdminRoleSaveDTO param);

    /**
     * 管理员角色连表 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(AdminRoleUpdateDTO param);

    /**
     * 管理员角色连表 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(Long[] ids);

}