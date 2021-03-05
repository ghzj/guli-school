package ${packagePath}.${moduleName}.${UpdateDTOPath}.${packageName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
@Data
@ApiModel("${tableComment} 更新 Request DTO")
public class ${className}${UpdateDTOName} {
<#list columns as column>
    /**
     * ${column.columnComment}
     */
    @ApiModelProperty(value = "${column.columnComment}")
    private ${column.attrType} ${column.humpAttrName};
</#list>
}