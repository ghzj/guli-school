package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.EduSubjectEntity;

import java.util.Map;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
public interface EduSubjectService extends IService<EduSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
