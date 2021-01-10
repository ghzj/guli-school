package io.github.ghzj.guli.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.Query;
import io.github.ghzj.guli.education.dao.EduVideoDao;
import io.github.ghzj.guli.education.entity.EduVideoEntity;
import io.github.ghzj.guli.education.service.EduVideoService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eduVideoService")
public class EduVideoServiceImpl extends ServiceImpl<EduVideoDao, EduVideoEntity> implements EduVideoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EduVideoEntity> page = this.page(
                new Query<EduVideoEntity>().getPage(params),
                new QueryWrapper<EduVideoEntity>()
        );

        return new PageUtils(page);
    }

}