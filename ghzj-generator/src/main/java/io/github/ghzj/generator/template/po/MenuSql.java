package io.github.ghzj.generator.template.po;

import io.github.ghzj.generator.template.ExecTemplate;
import io.github.ghzj.generator.template.TemplateAnnotation;

import java.util.Map;

/**
 * @author ghzj
 * @date 2021/1/17 21:25
 */
@TemplateAnnotation
public class MenuSql implements ExecTemplate {
    @Override
    public String getTemplatePathValue() {
        return "null";
    }

    @Override
    public String getFilePathName(String packagePath, Map<String, Object> map) {
        String className = (String) map.get("className");
        return className.toLowerCase() + "_menu.sql";
    }
}
