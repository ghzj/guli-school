package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.CourseDescriptionEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionListDTO;

import java.util.Map;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface CourseDescriptionService extends IService<CourseDescriptionEntity> {

    PageUtils<CourseDescriptionEntity> queryPage(CourseDescriptionListDTO params);
}