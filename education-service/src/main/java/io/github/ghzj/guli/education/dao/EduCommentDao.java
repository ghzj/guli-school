package io.github.ghzj.guli.education.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.ghzj.guli.education.entity.EduCommentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论
 * 
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@Mapper
public interface EduCommentDao extends BaseMapper<EduCommentEntity> {
	
}
