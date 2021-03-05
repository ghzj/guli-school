package ${packagePath}.${moduleName}.${EntityPath};

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
@Data
@TableName("${tableName}")
public class ${className}${EntityName} implements Serializable {
    private static final long serialVersionUID = 1L;

<#list columns as column>
    /**
     * ${column.columnComment}
     */
    <#if column.columnName == pk.columnName>
    @TableId
    </#if>
    <#if column.logicDelete >
    @TableField("${column.columnName}")
    @TableLogic
    </#if>
    private ${column.attrType} ${column.humpAttrName};
</#list>

}