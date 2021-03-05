package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.CourseEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseListDTO;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface CourseService extends IService<CourseEntity> {

    PageUtils queryPage(CourseListDTO params);
}