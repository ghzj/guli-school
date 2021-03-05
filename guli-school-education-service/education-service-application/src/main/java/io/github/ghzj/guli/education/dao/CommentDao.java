package io.github.ghzj.guli.education.dao;

import io.github.ghzj.guli.education.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {

}