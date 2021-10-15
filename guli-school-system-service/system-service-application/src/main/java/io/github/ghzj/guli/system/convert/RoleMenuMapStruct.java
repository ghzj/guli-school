package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.RoleMenuEntity;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.menu.RoleMenuUpdateDTO;
import io.github.ghzj.guli.system.object.view.role.menu.RoleMenuPageVO;
import io.github.ghzj.guli.system.object.view.role.menu.RoleMenuInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 角色菜单连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  RoleMenuMapStruct {
    RoleMenuMapStruct INSTANCE = Mappers.getMapper(RoleMenuMapStruct.class);

    /**
    * @param param RoleMenuSaveDTO
    * @return DTO2P
    */
    RoleMenuEntity DTO2P(RoleMenuSaveDTO param);

    /**
    * @param param RoleMenuUpdateDTO
    * @return DTO2P
    */
    RoleMenuEntity DTO2P(RoleMenuUpdateDTO param);

    /**
     * @param param RoleMenuEntity
     * @return P2IV
     */
    RoleMenuInfoVO P2IV(RoleMenuEntity param);

    /**
     * @param param RoleMenuEntity
     * @return P2GV
     */
    RoleMenuPageVO P2GV(RoleMenuEntity param);

    /**
     * @param param RoleMenuEntity
     * @return P2GV
     */
    List<RoleMenuPageVO> P2GV(List<RoleMenuEntity> param);

    /**
     * @param param RoleMenuEntity
     * @return P2GV
     */
    PageUtils<RoleMenuPageVO> P2GV(PageUtils<RoleMenuEntity> param);
}
