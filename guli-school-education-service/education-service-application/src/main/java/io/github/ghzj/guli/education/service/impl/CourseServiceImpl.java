package io.github.ghzj.guli.education.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.education.dao.CourseDao;
import io.github.ghzj.guli.education.entity.CourseEntity;
import io.github.ghzj.guli.education.service.CourseService;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {

    @Override
    public PageUtils<CourseEntity> queryPage(CourseListDTO params) {
        IPage<CourseEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<CourseEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}