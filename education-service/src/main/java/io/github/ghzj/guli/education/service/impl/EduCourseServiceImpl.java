package io.github.ghzj.guli.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.Query;
import io.github.ghzj.guli.education.dao.EduCourseDao;
import io.github.ghzj.guli.education.entity.EduCourseEntity;
import io.github.ghzj.guli.education.service.EduCourseService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eduCourseService")
public class EduCourseServiceImpl extends ServiceImpl<EduCourseDao, EduCourseEntity> implements EduCourseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EduCourseEntity> page = this.page(
                new Query<EduCourseEntity>().getPage(params),
                new QueryWrapper<EduCourseEntity>()
        );

        return new PageUtils(page);
    }

}