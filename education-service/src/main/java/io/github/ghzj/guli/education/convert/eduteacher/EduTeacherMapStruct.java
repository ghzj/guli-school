package io.github.ghzj.guli.education.convert.eduteacher;

import io.github.ghzj.guli.education.entity.EduTeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.eduteacher.SaveEduTeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author ghzj
 * @date 2021/1/12 21:25
 */
@Mapper
public interface  EduTeacherMapStruct {
    EduTeacherMapStruct INSTANCE = Mappers.getMapper(EduTeacherMapStruct.class);

    EduTeacherEntity DTO2P(SaveEduTeacherDTO saveEduTeacherDTO);
}
