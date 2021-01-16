package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.EduTeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.eduteacher.ListEduTeacherDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.ListTeacherDTO;

import java.util.Map;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
public interface EduTeacherService extends IService<EduTeacherEntity> {

    PageUtils queryPage(ListEduTeacherDTO listEduTeacherDTO);
}

