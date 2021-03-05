package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.SubjectEntity;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectListDTO;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
public interface SubjectService extends IService<SubjectEntity> {

    PageUtils queryPage(SubjectListDTO params);
}