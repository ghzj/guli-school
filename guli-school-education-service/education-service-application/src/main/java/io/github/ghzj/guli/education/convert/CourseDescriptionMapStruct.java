package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.CourseDescriptionEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Mapper
public interface  CourseDescriptionMapStruct {
    CourseDescriptionMapStruct INSTANCE = Mappers.getMapper(CourseDescriptionMapStruct.class);

    /**
    * @param param CourseDescriptionSaveDTO
    * @return DTO2P
    */
    CourseDescriptionEntity DTO2P(CourseDescriptionSaveDTO param);

    /**
    * @param param CourseDescriptionUpdateDTO
    * @return DTO2P
    */
    CourseDescriptionEntity DTO2P(CourseDescriptionUpdateDTO param);
}
