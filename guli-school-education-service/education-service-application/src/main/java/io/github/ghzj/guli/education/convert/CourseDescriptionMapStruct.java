package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.CourseDescriptionEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.description.CourseDescriptionPageVO;
import io.github.ghzj.guli.education.object.view.course.description.CourseDescriptionInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
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

    /**
     * @param param CourseDescriptionEntity
     * @return P2IV
     */
    CourseDescriptionInfoVO P2IV(CourseDescriptionEntity param);

    /**
     * @param param CourseDescriptionEntity
     * @return P2GV
     */
    CourseDescriptionPageVO P2GV(CourseDescriptionEntity param);

    /**
     * @param param CourseDescriptionEntity
     * @return P2GV
     */
    List<CourseDescriptionPageVO> P2GV(List<CourseDescriptionEntity> param);

    /**
     * @param param CourseDescriptionEntity
     * @return P2GV
     */
    PageUtils<CourseDescriptionPageVO> P2GV(PageUtils<CourseDescriptionEntity> param);
}
