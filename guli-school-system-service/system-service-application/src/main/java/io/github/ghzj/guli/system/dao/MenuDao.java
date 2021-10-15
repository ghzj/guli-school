package io.github.ghzj.guli.system.dao;

import io.github.ghzj.guli.system.entity.MenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统菜单
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-03-09 16:33:34
 */
@Mapper
public interface MenuDao extends BaseMapper<MenuEntity> {

}