package io.github.ghzj.guli.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.Query;
import io.github.ghzj.guli.education.dao.EduCourseDescriptionDao;
import io.github.ghzj.guli.education.entity.EduCourseDescriptionEntity;
import io.github.ghzj.guli.education.service.EduCourseDescriptionService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eduCourseDescriptionService")
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionDao, EduCourseDescriptionEntity> implements EduCourseDescriptionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EduCourseDescriptionEntity> page = this.page(
                new Query<EduCourseDescriptionEntity>().getPage(params),
                new QueryWrapper<EduCourseDescriptionEntity>()
        );

        return new PageUtils(page);
    }

}