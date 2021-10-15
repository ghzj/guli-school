package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.SubjectEntity;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectUpdateDTO;
import io.github.ghzj.guli.education.object.view.subject.SubjectPageVO;
import io.github.ghzj.guli.education.object.view.subject.SubjectInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
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

    /**
     * @param param SubjectEntity
     * @return P2IV
     */
    SubjectInfoVO P2IV(SubjectEntity param);

    /**
     * @param param SubjectEntity
     * @return P2GV
     */
    SubjectPageVO P2GV(SubjectEntity param);

    /**
     * @param param SubjectEntity
     * @return P2GV
     */
    List<SubjectPageVO> P2GV(List<SubjectEntity> param);

    /**
     * @param param SubjectEntity
     * @return P2GV
     */
    PageUtils<SubjectPageVO> P2GV(PageUtils<SubjectEntity> param);
}
