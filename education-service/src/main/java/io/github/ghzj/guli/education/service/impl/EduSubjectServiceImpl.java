package io.github.ghzj.guli.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.Query;
import io.github.ghzj.guli.education.dao.EduSubjectDao;
import io.github.ghzj.guli.education.entity.EduSubjectEntity;
import io.github.ghzj.guli.education.service.EduSubjectService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eduSubjectService")
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectDao, EduSubjectEntity> implements EduSubjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EduSubjectEntity> page = this.page(
                new Query<EduSubjectEntity>().getPage(params),
                new QueryWrapper<EduSubjectEntity>()
        );

        return new PageUtils(page);
    }

}