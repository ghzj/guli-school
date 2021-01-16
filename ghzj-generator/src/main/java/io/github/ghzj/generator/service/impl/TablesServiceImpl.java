package io.github.ghzj.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.generator.dao.ColumnsDao;
import io.github.ghzj.generator.dao.TablesDao;
import io.github.ghzj.generator.entity.ColumnsEntity;
import io.github.ghzj.generator.entity.TablesEntity;
import io.github.ghzj.generator.service.ColumnsService;
import io.github.ghzj.generator.service.TablesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Service
public class TablesServiceImpl extends ServiceImpl<TablesDao, TablesEntity> implements TablesService {
    @Override
    public TablesEntity queryTable(String tableName){
        QueryWrapper<TablesEntity> wrapper = new QueryWrapper<TablesEntity>()
                .eq("table_name", tableName)
                .eq("table_schema", "guli_education");

        return this.getOne(wrapper);
    }

    @Override
    public List<TablesEntity> queryList() {
        QueryWrapper<TablesEntity> wrapper = new QueryWrapper<TablesEntity>()
                .eq("table_schema", "guli_education")
                .orderByDesc("create_time");

        return this.list(wrapper);
    }
}