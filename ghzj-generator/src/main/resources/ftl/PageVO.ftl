package ${packagePath}.${moduleName}.${PageVOPath}.${packageName};

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
@ApiModel("${tableComment} 分页 Response VO")
public class ${className}${PageVOName} implements Serializable {
    private static final long serialVersionUID = 1L;

<#list columns as column>
    /**
     * ${column.columnComment}
     */
    @ApiModelProperty(value = "${column.columnComment}")
    private ${column.attrType} ${column.humpAttrName};
</#list>
}