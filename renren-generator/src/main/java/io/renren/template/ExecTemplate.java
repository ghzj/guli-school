package io.renren.template;

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

    String getFilePathName(String packagePath, Map<String, Object> map);

    default String getName() {
        return "template/" + getClass().getSimpleName() + ".java.vm";
    }

    default String getDTOFileName(String packagePath, Map<String, Object> map, String myPath) {
        String packageName = ((String) map.get("packageName")).replace(".", File.separator);
        String className = (String) map.get("className");
        String path = ((String) map.get(myPath)).replace(".", File.separator);
        return packagePath + path + File.separator + packageName + File.separator + className + getClass().getSimpleName() + ".java";
    }

    default String getFileName(String packagePath, Map<String, Object> map, String myPath) {
        String className = (String) map.get("className");
        String path = ((String) map.get(myPath)).replace(".", File.separator);
        return packagePath + path + File.separator + className + getClass().getSimpleName() + ".java";
    }
}
