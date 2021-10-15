package io.github.ghzj.guli.system.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuListDTO;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuUpdateDTO;
import io.github.ghzj.guli.system.object.view.menu.MenuPageVO;
import io.github.ghzj.guli.system.object.view.menu.MenuInfoVO;

/**
 * 系统菜单 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:03:28
 */
public interface MenuRpc {

    /**
     * 系统菜单 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<MenuPageVO>> pageMenu(MenuListDTO param);


    /**
     * 系统菜单 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<MenuInfoVO> info(Long id);

    /**
     * 系统菜单 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(MenuSaveDTO param);

    /**
     * 系统菜单 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(MenuUpdateDTO param);

    /**
     * 系统菜单 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(Long[] ids);

}