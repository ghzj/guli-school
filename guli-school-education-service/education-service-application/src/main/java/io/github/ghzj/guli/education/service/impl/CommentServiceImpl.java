package io.github.ghzj.guli.education.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.education.dao.CommentDao;
import io.github.ghzj.guli.education.entity.CommentEntity;
import io.github.ghzj.guli.education.service.CommentService;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentListDTO;
import io.github.ghzj.guli.common.mybatis.util.PageUtil;
import io.github.ghzj.guli.common.utils.OrderCodeUtil;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentEntity> implements CommentService {

    @Override
    public PageUtils<CommentEntity> queryPage(CommentListDTO params) {
        IPage<CommentEntity> page = this.page(
            PageUtil.build(params, OrderCodeUtil.getSortingFields(params)),
            new QueryWrapper<CommentEntity>());

        return new PageUtils<>(page.getRecords(),(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent(),(int)page.getPages());
    }

}