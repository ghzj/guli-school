package io.github.ghzj.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.generator.entity.TablesEntity;

import java.util.List;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
public interface TablesService extends IService<TablesEntity> {
    TablesEntity queryTable(String tableName);
    List<TablesEntity> queryList();
}