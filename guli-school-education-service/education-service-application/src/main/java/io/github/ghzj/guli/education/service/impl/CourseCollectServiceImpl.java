package io.github.ghzj.guli.education.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.education.dao.CourseCollectDao;
import io.github.ghzj.guli.education.entity.CourseCollectEntity;
import io.github.ghzj.guli.education.service.CourseCollectService;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Service("courseCollectService")
public class CourseCollectServiceImpl extends ServiceImpl<CourseCollectDao, CourseCollectEntity> implements CourseCollectService {

    @Override
    public PageUtils queryPage(CourseCollectListDTO params) {
        IPage<CourseCollectEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<CourseCollectEntity>());

        return new PageUtils(page);
    }

}