package io.github.ghzj.guli.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.Query;
import io.github.ghzj.guli.education.dao.EduChapterDao;
import io.github.ghzj.guli.education.entity.EduChapterEntity;
import io.github.ghzj.guli.education.service.EduChapterService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eduChapterService")
public class EduChapterServiceImpl extends ServiceImpl<EduChapterDao, EduChapterEntity> implements EduChapterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EduChapterEntity> page = this.page(
                new Query<EduChapterEntity>().getPage(params),
                new QueryWrapper<EduChapterEntity>()
        );

        return new PageUtils(page);
    }

}