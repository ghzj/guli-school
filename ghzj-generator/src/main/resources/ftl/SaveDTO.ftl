package ${packagePath}.${moduleName}.${SaveDTOPath}.${packageName};

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
@ApiModel("${tableComment} 添加 Request DTO")
public class ${className}${SaveDTOName} {
<#list columns as column>
    //${column.columnComment}
    @ApiModelProperty(value = "${column.columnComment}")
    private ${column.attrType} ${column.humpAttrName};
</#list>
}