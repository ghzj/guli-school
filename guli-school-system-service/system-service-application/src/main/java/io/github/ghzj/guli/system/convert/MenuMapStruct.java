package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.MenuEntity;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.menu.MenuUpdateDTO;
import io.github.ghzj.guli.system.object.view.menu.MenuPageVO;
import io.github.ghzj.guli.system.object.view.menu.MenuInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  MenuMapStruct {
    MenuMapStruct INSTANCE = Mappers.getMapper(MenuMapStruct.class);

    /**
    * @param param MenuSaveDTO
    * @return DTO2P
    */
    MenuEntity DTO2P(MenuSaveDTO param);

    /**
    * @param param MenuUpdateDTO
    * @return DTO2P
    */
    MenuEntity DTO2P(MenuUpdateDTO param);

    /**
     * @param param MenuEntity
     * @return P2IV
     */
    MenuInfoVO P2IV(MenuEntity param);

    /**
     * @param param MenuEntity
     * @return P2GV
     */
    MenuPageVO P2GV(MenuEntity param);

    /**
     * @param param MenuEntity
     * @return P2GV
     */
    List<MenuPageVO> P2GV(List<MenuEntity> param);

    /**
     * @param param MenuEntity
     * @return P2GV
     */
    PageUtils<MenuPageVO> P2GV(PageUtils<MenuEntity> param);
}
