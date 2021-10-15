package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.AdminRoleEntity;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.role.AdminRoleUpdateDTO;
import io.github.ghzj.guli.system.object.view.admin.role.AdminRolePageVO;
import io.github.ghzj.guli.system.object.view.admin.role.AdminRoleInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 管理员角色连表
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  AdminRoleMapStruct {
    AdminRoleMapStruct INSTANCE = Mappers.getMapper(AdminRoleMapStruct.class);

    /**
    * @param param AdminRoleSaveDTO
    * @return DTO2P
    */
    AdminRoleEntity DTO2P(AdminRoleSaveDTO param);

    /**
    * @param param AdminRoleUpdateDTO
    * @return DTO2P
    */
    AdminRoleEntity DTO2P(AdminRoleUpdateDTO param);

    /**
     * @param param AdminRoleEntity
     * @return P2IV
     */
    AdminRoleInfoVO P2IV(AdminRoleEntity param);

    /**
     * @param param AdminRoleEntity
     * @return P2GV
     */
    AdminRolePageVO P2GV(AdminRoleEntity param);

    /**
     * @param param AdminRoleEntity
     * @return P2GV
     */
    List<AdminRolePageVO> P2GV(List<AdminRoleEntity> param);

    /**
     * @param param AdminRoleEntity
     * @return P2GV
     */
    PageUtils<AdminRolePageVO> P2GV(PageUtils<AdminRoleEntity> param);
}
