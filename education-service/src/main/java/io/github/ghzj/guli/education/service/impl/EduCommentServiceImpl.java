package io.github.ghzj.guli.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.Query;
import io.github.ghzj.guli.education.dao.EduCommentDao;
import io.github.ghzj.guli.education.entity.EduCommentEntity;
import io.github.ghzj.guli.education.service.EduCommentService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eduCommentService")
public class EduCommentServiceImpl extends ServiceImpl<EduCommentDao, EduCommentEntity> implements EduCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EduCommentEntity> page = this.page(
                new Query<EduCommentEntity>().getPage(params),
                new QueryWrapper<EduCommentEntity>()
        );

        return new PageUtils(page);
    }

}