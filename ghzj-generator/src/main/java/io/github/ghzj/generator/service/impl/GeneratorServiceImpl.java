package io.github.ghzj.generator.service.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.github.ghzj.generator.entity.ColumnsEntity;
import io.github.ghzj.generator.entity.ExtendEntity;
import io.github.ghzj.generator.entity.TablesEntity;
import io.github.ghzj.generator.entity.properties.GeneratorProperties;
import io.github.ghzj.generator.service.ColumnsService;
import io.github.ghzj.generator.service.GeneratorService;
import io.github.ghzj.generator.service.TablesService;
import io.github.ghzj.generator.template.CustomTemplateFactory;
import io.github.ghzj.generator.utils.DateUtils;
import io.github.ghzj.generator.utils.GeneratorPropertiesUtils;
import io.github.ghzj.generator.utils.GeneratorStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Slf4j
@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private ColumnsService columnsService;

    @Autowired
    private TablesService tablesService;

    @Autowired
    private CustomTemplateFactory customTemplateFactory;

    @Autowired
    private GeneratorProperties generatorProperties;

    @Override
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            //查询表信息
            TablesEntity table = tablesService.queryTable(tableName);
            //查询列信息
            List<ColumnsEntity> columns = columnsService.queryColumns(tableName);
            //生成代码
            this.generatorCode(table, columns, zip);
        }

        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }


    private void generatorCode(TablesEntity table,
                               List<ColumnsEntity> columns, ZipOutputStream zip) {
        boolean hasBigDecimal = false;
        boolean hasList = false;
        //表名转换成Java类名
        setClassNameAndHumpClassName(table);

        //列信息
        for (ColumnsEntity column : columns) {

            String columnName = column.getColumnName();
            if (column.getColumnName().startsWith("is_")){
                columnName = columnName.replace("is_","");
                column.setLogicDelete(true);
            }

            //列名转换成Java属性名
            //列的数据类型，转换成Java类型
            setAttrNameAndHumpAttrNameAndAttrType(columnName,column);

            if (!hasBigDecimal && "BigDecimal".equals(column.getAttrType())) {
                hasBigDecimal = true;
            }

            if (!hasList && "array".equals(column.getExtra())) {
                hasList = true;
            }

            //是否主键
            if ("PRI".equalsIgnoreCase(column.getColumnKey()) && table.getPk() == null) {
                table.setPk(column);
            }
        }

        table.setColumns(columns);

        //没主键，则第一个字段为主键
        if (table.getPk() == null) {
            table.setPk(table.getColumns().get(0));
        }

        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.putAll(customTemplateFactory.getMap());
        map.putAll(objToMap(generatorProperties));
        map.putAll(objToMap(table));
        map.putAll(objToMap(new ExtendEntity(hasBigDecimal, hasList).extend(table,generatorProperties)));

        //获取模板列表
        List<String> templates = customTemplateFactory.gettemplates();


        //定义配置类
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        //获取当前类的target下的的test-classes目录路径
        String path = this.getClass().getResource("/").getPath();
        try {
            //定义模板--设置模板路径
            configuration.setDirectoryForTemplateLoading(new File(path + customTemplateFactory.getTemplatePath()));

            //渲染模板
            for (String template : templates) {
                //设置模板文件
                Template templateFile = configuration.getTemplate(template);
                //将模板和数据模型结合生成html文本
                String content = FreeMarkerTemplateUtils.processTemplateIntoString(templateFile, map);
                //添加到zip
                zip.putNextEntry(new ZipEntry(customTemplateFactory.getFileName(template, map)));
                IOUtils.write(content, zip, "UTF-8");
                zip.closeEntry();
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            throw new RuntimeException("渲染模板失败，表名：" + table.getTableName(), e);
        }


    }

    private void setClassNameAndHumpClassName(TablesEntity table) {
        String className = GeneratorStringUtils.tableToJava(table.getTableName(), generatorProperties.getTablePrefix());
        table.setClassName(className);
        table.setHumpClassName(StringUtils.uncapitalize(className));
    }

    private void setAttrNameAndHumpAttrNameAndAttrType(String columnName,ColumnsEntity column) {
        String attrName = GeneratorStringUtils.columnToJava(columnName);
        column.setAttrName(attrName);
        column.setHumpAttrName(StringUtils.uncapitalize(attrName));
        String attrType = GeneratorPropertiesUtils.getConfigurationString(column.getDataType(),
                GeneratorStringUtils.columnToJava(column.getDataType()));
        column.setAttrType(attrType);
    }

    private Map<String, Object> objToMap(Object obj) {

        Map<String, Object> map = new HashMap<String, Object>();
        // 获取f对象对应类中的所有属性域
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            String varName = field.getName();
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = field.isAccessible();
                // 修改访问控制权限
                field.setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o = field.get(obj);
                if (o != null) {
                    map.put(varName, o);
                }
                // 恢复访问控制权限
                field.setAccessible(accessFlag);
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }

}