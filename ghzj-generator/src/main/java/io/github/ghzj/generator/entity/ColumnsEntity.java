package io.github.ghzj.generator.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Data
@TableName("columns")
public class ColumnsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 列名
     */
    private String columnName;
    /**
     * 数据库数据类型
     */
    private String dataType;
    /**
     * 列注释
     */
    private String columnComment;
    /**
     * 是否是主键
     */
    private String columnKey;
    /**
     * extra
     */
    private String extra;

    /**
     * 属性名称(第一个字母大写)，如：user_name => UserName
     */
    @TableField(exist = false)
    private String attrName;
    /**
     * 属性名称(第一个字母小写)，如：user_name => userName
     */
    @TableField(exist = false)
    private String humpAttrName;
    /**
     * 属性类型
     */
    @TableField(exist = false)
    private String attrType;

}
