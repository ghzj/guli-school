package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.SubjectEntity;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectListDTO;

import java.util.Map;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface SubjectService extends IService<SubjectEntity> {

    PageUtils<SubjectEntity> queryPage(SubjectListDTO params);
}