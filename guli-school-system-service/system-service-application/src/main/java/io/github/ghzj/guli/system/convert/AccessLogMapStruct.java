package io.github.ghzj.guli.system.convert;

import io.github.ghzj.guli.system.entity.AccessLogEntity;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogSaveDTO;
import io.github.ghzj.guli.system.object.transfer.data.access.log.AccessLogUpdateDTO;
import io.github.ghzj.guli.system.object.view.access.log.AccessLogPageVO;
import io.github.ghzj.guli.system.object.view.access.log.AccessLogInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统访问日志
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface  AccessLogMapStruct {
    AccessLogMapStruct INSTANCE = Mappers.getMapper(AccessLogMapStruct.class);

    /**
    * @param param AccessLogSaveDTO
    * @return DTO2P
    */
    AccessLogEntity DTO2P(AccessLogSaveDTO param);

    /**
    * @param param AccessLogUpdateDTO
    * @return DTO2P
    */
    AccessLogEntity DTO2P(AccessLogUpdateDTO param);

    /**
     * @param param AccessLogEntity
     * @return P2IV
     */
    AccessLogInfoVO P2IV(AccessLogEntity param);

    /**
     * @param param AccessLogEntity
     * @return P2GV
     */
    AccessLogPageVO P2GV(AccessLogEntity param);

    /**
     * @param param AccessLogEntity
     * @return P2GV
     */
    List<AccessLogPageVO> P2GV(List<AccessLogEntity> param);

    /**
     * @param param AccessLogEntity
     * @return P2GV
     */
    PageUtils<AccessLogPageVO> P2GV(PageUtils<AccessLogEntity> param);
}
