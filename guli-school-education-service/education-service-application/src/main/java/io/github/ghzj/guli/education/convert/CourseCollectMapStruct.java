package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.CourseCollectEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Mapper
public interface  CourseCollectMapStruct {
    CourseCollectMapStruct INSTANCE = Mappers.getMapper(CourseCollectMapStruct.class);

    /**
    * @param param CourseCollectSaveDTO
    * @return DTO2P
    */
    CourseCollectEntity DTO2P(CourseCollectSaveDTO param);

    /**
    * @param param CourseCollectUpdateDTO
    * @return DTO2P
    */
    CourseCollectEntity DTO2P(CourseCollectUpdateDTO param);
}
