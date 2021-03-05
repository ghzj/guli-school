package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.CourseCollectEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectListDTO;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface CourseCollectService extends IService<CourseCollectEntity> {

    PageUtils queryPage(CourseCollectListDTO params);
}