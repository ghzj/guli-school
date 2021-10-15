package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.CourseEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.CoursePageVO;
import io.github.ghzj.guli.education.object.view.course.CourseInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
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

    /**
     * @param param CourseEntity
     * @return P2IV
     */
    CourseInfoVO P2IV(CourseEntity param);

    /**
     * @param param CourseEntity
     * @return P2GV
     */
    CoursePageVO P2GV(CourseEntity param);

    /**
     * @param param CourseEntity
     * @return P2GV
     */
    List<CoursePageVO> P2GV(List<CourseEntity> param);

    /**
     * @param param CourseEntity
     * @return P2GV
     */
    PageUtils<CoursePageVO> P2GV(PageUtils<CourseEntity> param);
}
