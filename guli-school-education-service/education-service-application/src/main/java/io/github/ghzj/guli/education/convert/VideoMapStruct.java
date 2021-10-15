package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.VideoEntity;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoUpdateDTO;
import io.github.ghzj.guli.education.object.view.video.VideoPageVO;
import io.github.ghzj.guli.education.object.view.video.VideoInfoVO;
import io.github.ghzj.guli.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Mapper
public interface  VideoMapStruct {
    VideoMapStruct INSTANCE = Mappers.getMapper(VideoMapStruct.class);

    /**
    * @param param VideoSaveDTO
    * @return DTO2P
    */
    VideoEntity DTO2P(VideoSaveDTO param);

    /**
    * @param param VideoUpdateDTO
    * @return DTO2P
    */
    VideoEntity DTO2P(VideoUpdateDTO param);

    /**
     * @param param VideoEntity
     * @return P2IV
     */
    VideoInfoVO P2IV(VideoEntity param);

    /**
     * @param param VideoEntity
     * @return P2GV
     */
    VideoPageVO P2GV(VideoEntity param);

    /**
     * @param param VideoEntity
     * @return P2GV
     */
    List<VideoPageVO> P2GV(List<VideoEntity> param);

    /**
     * @param param VideoEntity
     * @return P2GV
     */
    PageUtils<VideoPageVO> P2GV(PageUtils<VideoEntity> param);
}
