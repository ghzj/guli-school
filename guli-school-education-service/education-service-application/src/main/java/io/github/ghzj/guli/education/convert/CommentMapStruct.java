package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.CommentEntity;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentUpdateDTO;
import io.github.ghzj.guli.education.object.view.comment.CommentPageVO;
import io.github.ghzj.guli.education.object.view.comment.CommentInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
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

    /**
     * @param param CommentEntity
     * @return P2IV
     */
    CommentInfoVO P2IV(CommentEntity param);

    /**
     * @param param CommentEntity
     * @return P2GV
     */
    CommentPageVO P2GV(CommentEntity param);

    /**
     * @param param CommentEntity
     * @return P2GV
     */
    List<CommentPageVO> P2GV(List<CommentEntity> param);

    /**
     * @param param CommentEntity
     * @return P2GV
     */
    PageUtils<CommentPageVO> P2GV(PageUtils<CommentEntity> param);
}
