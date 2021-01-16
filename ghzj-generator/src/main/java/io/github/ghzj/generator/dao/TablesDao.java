package io.github.ghzj.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.ghzj.generator.entity.TablesEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Mapper
public interface TablesDao extends BaseMapper<TablesEntity> {

}