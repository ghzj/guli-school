package io.github.ghzj.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.ghzj.generator.dao.ColumnsDao;
import io.github.ghzj.generator.entity.ColumnsEntity;
import io.github.ghzj.generator.entity.properties.GeneratorProperties;
import io.github.ghzj.generator.service.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Service
public class ColumnsServiceImpl extends ServiceImpl<ColumnsDao, ColumnsEntity> implements ColumnsService {

    @Autowired
    private GeneratorProperties generatorProperties;

    @Override
    public List<ColumnsEntity> queryColumns(String tableName){
        QueryWrapper<ColumnsEntity> wrapper = new QueryWrapper<ColumnsEntity>()
                .eq("table_name", tableName)
                .eq("table_schema", generatorProperties.getTableSchema())
                .orderByAsc("ordinal_position");

        return this.list(wrapper);
    }

}
