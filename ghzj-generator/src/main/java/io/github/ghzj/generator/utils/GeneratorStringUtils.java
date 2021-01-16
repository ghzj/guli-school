package io.github.ghzj.generator.utils;

import org.apache.commons.lang.WordUtils;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
public class GeneratorStringUtils {
    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String[] tablePrefixArray) {
        return columnToJava(getNoPrefixTableName(tableName, tablePrefixArray));
    }

    public static String tableToPackageName(String tableName, String[] tablePrefixArray) {
        return getNoPrefixTableName(tableName, tablePrefixArray).replace("_", ".");
    }

    private static String getNoPrefixTableName(String tableName, String[] tablePrefixArray) {
        if (null != tablePrefixArray && tablePrefixArray.length > 0) {
            for (String tablePrefix : tablePrefixArray) {
                if (tableName.startsWith(tablePrefix)) {
                    tableName = tableName.replaceFirst(tablePrefix, "");
                }
            }
        }
        return tableName;
    }
}
