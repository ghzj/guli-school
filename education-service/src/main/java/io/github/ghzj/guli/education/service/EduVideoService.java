package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.EduVideoEntity;

import java.util.Map;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
public interface EduVideoService extends IService<EduVideoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

