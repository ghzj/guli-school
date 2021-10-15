package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.VideoEntity;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoListDTO;

import java.util.Map;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface VideoService extends IService<VideoEntity> {

    PageUtils<VideoEntity> queryPage(VideoListDTO params);
}