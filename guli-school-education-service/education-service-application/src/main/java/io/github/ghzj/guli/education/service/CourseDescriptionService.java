package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.CourseDescriptionEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionListDTO;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface CourseDescriptionService extends IService<CourseDescriptionEntity> {

    PageUtils queryPage(CourseDescriptionListDTO params);
}