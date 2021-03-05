package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.TeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface TeacherService extends IService<TeacherEntity> {

    PageUtils queryPage(TeacherListDTO params);
}