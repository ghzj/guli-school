package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.TeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;

import java.util.Map;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface TeacherService extends IService<TeacherEntity> {

    PageUtils<TeacherEntity> queryPage(TeacherListDTO params);
}