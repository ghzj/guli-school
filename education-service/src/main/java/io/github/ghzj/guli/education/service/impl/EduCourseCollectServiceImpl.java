package io.github.ghzj.guli.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.Query;
import io.github.ghzj.guli.education.dao.EduCourseCollectDao;
import io.github.ghzj.guli.education.entity.EduCourseCollectEntity;
import io.github.ghzj.guli.education.service.EduCourseCollectService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eduCourseCollectService")
public class EduCourseCollectServiceImpl extends ServiceImpl<EduCourseCollectDao, EduCourseCollectEntity> implements EduCourseCollectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EduCourseCollectEntity> page = this.page(
                new Query<EduCourseCollectEntity>().getPage(params),
                new QueryWrapper<EduCourseCollectEntity>()
        );

        return new PageUtils(page);
    }

}