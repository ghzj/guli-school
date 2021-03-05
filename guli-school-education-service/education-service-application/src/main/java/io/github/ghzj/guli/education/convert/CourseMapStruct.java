package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.CourseEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseUpdateDTO;
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
public interface  CourseMapStruct {
    CourseMapStruct INSTANCE = Mappers.getMapper(CourseMapStruct.class);

    /**
    * @param param CourseSaveDTO
    * @return DTO2P
    */
    CourseEntity DTO2P(CourseSaveDTO param);

    /**
    * @param param CourseUpdateDTO
    * @return DTO2P
    */
    CourseEntity DTO2P(CourseUpdateDTO param);
}
