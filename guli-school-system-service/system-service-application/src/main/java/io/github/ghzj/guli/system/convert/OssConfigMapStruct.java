package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.OssConfigEntity;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.oss.config.OssConfigUpdateDTO;
import io.github.ghzj.guli.system.object.view.oss.config.OssConfigPageVO;
import io.github.ghzj.guli.system.object.view.oss.config.OssConfigInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统oss配置
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  OssConfigMapStruct {
    OssConfigMapStruct INSTANCE = Mappers.getMapper(OssConfigMapStruct.class);

    /**
    * @param param OssConfigSaveDTO
    * @return DTO2P
    */
    OssConfigEntity DTO2P(OssConfigSaveDTO param);

    /**
    * @param param OssConfigUpdateDTO
    * @return DTO2P
    */
    OssConfigEntity DTO2P(OssConfigUpdateDTO param);

    /**
     * @param param OssConfigEntity
     * @return P2IV
     */
    OssConfigInfoVO P2IV(OssConfigEntity param);

    /**
     * @param param OssConfigEntity
     * @return P2GV
     */
    OssConfigPageVO P2GV(OssConfigEntity param);

    /**
     * @param param OssConfigEntity
     * @return P2GV
     */
    List<OssConfigPageVO> P2GV(List<OssConfigEntity> param);

    /**
     * @param param OssConfigEntity
     * @return P2GV
     */
    PageUtils<OssConfigPageVO> P2GV(PageUtils<OssConfigEntity> param);
}
