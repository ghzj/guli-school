package io.github.ghzj.guli.education.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.education.dao.ChapterDao;
import io.github.ghzj.guli.education.entity.ChapterEntity;
import io.github.ghzj.guli.education.service.ChapterService;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
@Service("chapterService")
public class ChapterServiceImpl extends ServiceImpl<ChapterDao, ChapterEntity> implements ChapterService {

    @Override
    public PageUtils<ChapterEntity> queryPage(ChapterListDTO params) {
        IPage<ChapterEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<ChapterEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}