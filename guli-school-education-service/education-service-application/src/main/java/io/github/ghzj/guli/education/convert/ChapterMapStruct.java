package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.ChapterEntity;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
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
}
