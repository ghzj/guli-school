package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.TeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
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
}
