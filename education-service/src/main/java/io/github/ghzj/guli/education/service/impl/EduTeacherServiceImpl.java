package io.github.ghzj.guli.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.mybatis.query.QueryWrapperX;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.Query;
import io.github.ghzj.guli.education.dao.EduTeacherDao;
import io.github.ghzj.guli.education.entity.EduTeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.eduteacher.ListEduTeacherDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.ListTeacherDTO;
import io.github.ghzj.guli.education.service.EduTeacherService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eduTeacherService")
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherDao, EduTeacherEntity> implements EduTeacherService {

    @Override
    public PageUtils queryPage(ListEduTeacherDTO listEduTeacherDTO) {
        IPage<EduTeacherEntity> page = this.page(
                PageUtil.build(listEduTeacherDTO, OrderCodeUtil.getSortingFields(listEduTeacherDTO)),
                new QueryWrapperX<EduTeacherEntity>()
                        .eqIfPresent("name",listEduTeacherDTO.getName())
                        .eqIfPresent("level",listEduTeacherDTO.getLevel())
                        .betweenIfPresent("gmt_create",listEduTeacherDTO.getBegin(),listEduTeacherDTO.getEnd())
        );

        return new PageUtils(page);
    }

}