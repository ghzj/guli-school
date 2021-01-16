package io.github.ghzj.generator.template;

import java.io.File;
import java.util.Map;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
public interface ExecTemplate {
    default boolean isFileName(String template) {
        return template.equals(getName());
    }

    default String getFilePathName(String packagePath, Map<String, Object> map){
        return getFileName(packagePath,map);
    }

    default String getName() {
        return  getClass().getSimpleName() + ".ftl";
    }

    default String getTemplateName(){
        return  getClass().getSimpleName()+"Name:"+getClass().getSimpleName();
    }

    default String getTemplatePathName(){
        return getClass().getSimpleName()+"Path:"+getTemplatePathValue();
    }

    String getTemplatePathValue();

    default String getDTOFileName(String packagePath, Map<String, Object> map) {
        String packageName = ((String) map.get("packageName")).replace(".", File.separator);
        String className = (String) map.get("className");
        String path = getTemplatePathValue().replace(".", File.separator);
        return packagePath + path + File.separator + packageName + File.separator + className + getClass().getSimpleName() + ".java";
    }

    default String getFileName(String packagePath, Map<String, Object> map) {
        String className = (String) map.get("className");
        String path = getTemplatePathValue().replace(".", File.separator);
        return packagePath + path + File.separator + className + getClass().getSimpleName() + ".java";
    }
}
