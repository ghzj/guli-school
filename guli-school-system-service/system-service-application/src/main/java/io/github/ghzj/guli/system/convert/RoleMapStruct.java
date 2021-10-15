package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.RoleEntity;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.role.RoleUpdateDTO;
import io.github.ghzj.guli.system.object.view.role.RolePageVO;
import io.github.ghzj.guli.system.object.view.role.RoleInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统角色
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  RoleMapStruct {
    RoleMapStruct INSTANCE = Mappers.getMapper(RoleMapStruct.class);

    /**
    * @param param RoleSaveDTO
    * @return DTO2P
    */
    RoleEntity DTO2P(RoleSaveDTO param);

    /**
    * @param param RoleUpdateDTO
    * @return DTO2P
    */
    RoleEntity DTO2P(RoleUpdateDTO param);

    /**
     * @param param RoleEntity
     * @return P2IV
     */
    RoleInfoVO P2IV(RoleEntity param);

    /**
     * @param param RoleEntity
     * @return P2GV
     */
    RolePageVO P2GV(RoleEntity param);

    /**
     * @param param RoleEntity
     * @return P2GV
     */
    List<RolePageVO> P2GV(List<RoleEntity> param);

    /**
     * @param param RoleEntity
     * @return P2GV
     */
    PageUtils<RolePageVO> P2GV(PageUtils<RoleEntity> param);
}
