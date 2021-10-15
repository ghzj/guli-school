package io.github.ghzj.guli.education.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.education.dao.CourseDescriptionDao;
import io.github.ghzj.guli.education.entity.CourseDescriptionEntity;
import io.github.ghzj.guli.education.service.CourseDescriptionService;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Service("courseDescriptionService")
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionDao, CourseDescriptionEntity> implements CourseDescriptionService {

    @Override
    public PageUtils<CourseDescriptionEntity> queryPage(CourseDescriptionListDTO params) {
        IPage<CourseDescriptionEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<CourseDescriptionEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}