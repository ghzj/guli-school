package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.ChapterEntity;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterUpdateDTO;
import io.github.ghzj.guli.education.object.view.chapter.ChapterPageVO;
import io.github.ghzj.guli.education.object.view.chapter.ChapterInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
@Mapper
public interface  ChapterMapStruct {
    ChapterMapStruct INSTANCE = Mappers.getMapper(ChapterMapStruct.class);

    /**
    * @param param ChapterSaveDTO
    * @return DTO2P
    */
    ChapterEntity DTO2P(ChapterSaveDTO param);

    /**
    * @param param ChapterUpdateDTO
    * @return DTO2P
    */
    ChapterEntity DTO2P(ChapterUpdateDTO param);

    /**
     * @param param ChapterEntity
     * @return P2IV
     */
    ChapterInfoVO P2IV(ChapterEntity param);

    /**
     * @param param ChapterEntity
     * @return P2GV
     */
    ChapterPageVO P2GV(ChapterEntity param);

    /**
     * @param param ChapterEntity
     * @return P2GV
     */
    List<ChapterPageVO> P2GV(List<ChapterEntity> param);

    /**
     * @param param ChapterEntity
     * @return P2GV
     */
    PageUtils<ChapterPageVO> P2GV(PageUtils<ChapterEntity> param);
}
