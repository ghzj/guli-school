package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.VideoEntity;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoListDTO;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface VideoService extends IService<VideoEntity> {

    PageUtils queryPage(VideoListDTO params);
}