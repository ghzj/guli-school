package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.CourseCollectEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.collect.CourseCollectPageVO;
import io.github.ghzj.guli.education.object.view.course.collect.CourseCollectInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
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

    /**
     * @param param CourseCollectEntity
     * @return P2IV
     */
    CourseCollectInfoVO P2IV(CourseCollectEntity param);

    /**
     * @param param CourseCollectEntity
     * @return P2GV
     */
    CourseCollectPageVO P2GV(CourseCollectEntity param);

    /**
     * @param param CourseCollectEntity
     * @return P2GV
     */
    List<CourseCollectPageVO> P2GV(List<CourseCollectEntity> param);

    /**
     * @param param CourseCollectEntity
     * @return P2GV
     */
    PageUtils<CourseCollectPageVO> P2GV(PageUtils<CourseCollectEntity> param);
}
