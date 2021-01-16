package io.github.ghzj.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.generator.entity.ColumnsEntity;

import java.util.List;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
public interface ColumnsService extends IService<ColumnsEntity> {
    List<ColumnsEntity> queryColumns(String tableName);
}
