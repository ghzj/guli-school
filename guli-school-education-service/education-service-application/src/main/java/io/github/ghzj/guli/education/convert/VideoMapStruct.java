package io.github.ghzj.guli.education.convert;

import io.github.ghzj.guli.education.entity.VideoEntity;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
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
}
