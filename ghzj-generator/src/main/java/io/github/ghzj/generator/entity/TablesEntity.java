package io.github.ghzj.generator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Data
@TableName("tables")
public class TablesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表名
     */
    private String tableName;
    /**
     * 表引擎
     */
    private String engine;
    /**
     * 表注释
     */
    private String tableComment;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 类名(第一个字母大写)，如：sys_user => SysUser
     */
    @TableField(exist = false)
    private String className;
    /**
     * 类名(第一个字母小写)，如：sys_user => sysUser
     */
    @TableField(exist = false)
    private String humpClassName;

    /**
     * 表的主键
     */
    @TableField(exist = false)
    private ColumnsEntity pk;
    /**
     * 表的列名(不包含主键)
     */
    @TableField(exist = false)
    private List<ColumnsEntity> columns;
}
