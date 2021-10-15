package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.CommentEntity;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentListDTO;

import java.util.Map;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
public interface CommentService extends IService<CommentEntity> {

    PageUtils<CommentEntity> queryPage(CommentListDTO params);
}