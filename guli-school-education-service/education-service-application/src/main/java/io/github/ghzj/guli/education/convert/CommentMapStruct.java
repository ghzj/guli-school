package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.CommentEntity;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Mapper
public interface  CommentMapStruct {
    CommentMapStruct INSTANCE = Mappers.getMapper(CommentMapStruct.class);

    /**
    * @param param CommentSaveDTO
    * @return DTO2P
    */
    CommentEntity DTO2P(CommentSaveDTO param);

    /**
    * @param param CommentUpdateDTO
    * @return DTO2P
    */
    CommentEntity DTO2P(CommentUpdateDTO param);
}
