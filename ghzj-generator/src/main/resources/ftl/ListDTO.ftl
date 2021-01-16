package ${packagePath}.${moduleName}.${ListDTOPath}.${packageName};

import ${packagePath}.common.vo.OrderParam;
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
@ApiModel("${tableComment} 分页 Request DTO")
public class ${className}${ListDTOName} extends OrderParam {
<#list columns as column>
    //${column.columnComment}
    @ApiModelProperty(value = "${column.columnComment}")
    private ${column.attrType} ${column.humpAttrName};
</#list>
}