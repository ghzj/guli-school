package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.TeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherUpdateDTO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherPageVO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Mapper
public interface  TeacherMapStruct {
    TeacherMapStruct INSTANCE = Mappers.getMapper(TeacherMapStruct.class);

    /**
    * @param param TeacherSaveDTO
    * @return DTO2P
    */
    TeacherEntity DTO2P(TeacherSaveDTO param);

    /**
    * @param param TeacherUpdateDTO
    * @return DTO2P
    */
    TeacherEntity DTO2P(TeacherUpdateDTO param);

    /**
     * @param param TeacherEntity
     * @return P2IV
     */
    TeacherInfoVO P2IV(TeacherEntity param);

    /**
     * @param param TeacherEntity
     * @return P2GV
     */
    TeacherPageVO P2GV(TeacherEntity param);

    /**
     * @param param TeacherEntity
     * @return P2GV
     */
    List<TeacherPageVO> P2GV(List<TeacherEntity> param);

    /**
     * @param param TeacherEntity
     * @return P2GV
     */
    PageUtils<TeacherPageVO> P2GV(PageUtils<TeacherEntity> param);
}
