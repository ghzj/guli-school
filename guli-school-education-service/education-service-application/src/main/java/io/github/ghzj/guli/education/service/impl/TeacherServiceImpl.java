package io.github.ghzj.guli.education.service.impl;


import io.github.ghzj.guli.common.mybatis.query.QueryWrapperX;
import io.github.ghzj.guli.education.object.view.teacher.TeacherPageVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.education.dao.TeacherDao;
import io.github.ghzj.guli.education.entity.TeacherEntity;
import io.github.ghzj.guli.education.service.TeacherService;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {

    @Override
    public PageUtils<TeacherEntity> queryPage(TeacherListDTO params) {
        IPage<TeacherEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
                new QueryWrapperX<TeacherEntity>()
                        .eqIfPresent("name",params.getName())
                        .eqIfPresent("level",params.getLevel())
                        .betweenIfPresent("gmt_create",params.getBegin(),params.getEnd()));

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}