package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.AdminEntity;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.admin.AdminUpdateDTO;
import io.github.ghzj.guli.system.object.view.admin.AdminPageVO;
import io.github.ghzj.guli.system.object.view.admin.AdminInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统用户
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  AdminMapStruct {
    AdminMapStruct INSTANCE = Mappers.getMapper(AdminMapStruct.class);

    /**
    * @param param AdminSaveDTO
    * @return DTO2P
    */
    AdminEntity DTO2P(AdminSaveDTO param);

    /**
    * @param param AdminUpdateDTO
    * @return DTO2P
    */
    AdminEntity DTO2P(AdminUpdateDTO param);

    /**
     * @param param AdminEntity
     * @return P2IV
     */
    AdminInfoVO P2IV(AdminEntity param);

    /**
     * @param param AdminEntity
     * @return P2GV
     */
    AdminPageVO P2GV(AdminEntity param);

    /**
     * @param param AdminEntity
     * @return P2GV
     */
    List<AdminPageVO> P2GV(List<AdminEntity> param);

    /**
     * @param param AdminEntity
     * @return P2GV
     */
    PageUtils<AdminPageVO> P2GV(PageUtils<AdminEntity> param);
}
