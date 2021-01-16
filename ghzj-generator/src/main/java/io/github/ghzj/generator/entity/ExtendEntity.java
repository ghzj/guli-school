package io.github.ghzj.generator.entity;

import io.github.ghzj.generator.aspect.ErrorCodeContextHolder;
import io.github.ghzj.generator.entity.properties.GeneratorProperties;
import io.github.ghzj.generator.utils.DateUtils;
import io.github.ghzj.generator.utils.GeneratorPropertiesUtils;
import io.github.ghzj.generator.utils.GeneratorStringUtils;
import lombok.Data;

import java.util.Date;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Data
public class ExtendEntity {
    private boolean hasBigDecimal;
    private boolean hasList;
    private String datetime = DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN);
    private String packageName;
    private String tableNameToUpperCase;
    private Integer errorCode;
    private String pathName;

    public ExtendEntity() {
    }

    public ExtendEntity(boolean hasBigDecimal, boolean hasList) {
        this.hasBigDecimal = hasBigDecimal;
        this.hasList = hasList;
    }

    public ExtendEntity extend(TablesEntity tablesEntity, GeneratorProperties generatorProperties) {
        this.packageName = GeneratorStringUtils.tableToPackageName(tablesEntity.getTableName(),
                generatorProperties.getTablePrefix());
        this.tableNameToUpperCase = tablesEntity.getTableName().toUpperCase();
        this.errorCode =  ErrorCodeContextHolder.getErrorCode(tablesEntity.getTableName());
        this.pathName = tablesEntity.getClassName().toLowerCase();
        return this;
    }

}
