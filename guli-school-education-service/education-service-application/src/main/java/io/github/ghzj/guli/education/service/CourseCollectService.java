package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.CourseCollectEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectListDTO;

import java.util.Map;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface CourseCollectService extends IService<CourseCollectEntity> {

    PageUtils<CourseCollectEntity> queryPage(CourseCollectListDTO params);
}