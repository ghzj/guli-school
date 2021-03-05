package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.SubjectEntity;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Mapper
public interface  SubjectMapStruct {
    SubjectMapStruct INSTANCE = Mappers.getMapper(SubjectMapStruct.class);

    /**
    * @param param SubjectSaveDTO
    * @return DTO2P
    */
    SubjectEntity DTO2P(SubjectSaveDTO param);

    /**
    * @param param SubjectUpdateDTO
    * @return DTO2P
    */
    SubjectEntity DTO2P(SubjectUpdateDTO param);
}
