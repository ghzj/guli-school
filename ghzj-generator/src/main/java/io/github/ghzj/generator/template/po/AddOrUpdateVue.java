package io.github.ghzj.generator.template.po;

import io.github.ghzj.generator.template.ExecTemplate;
import io.github.ghzj.generator.template.TemplateAnnotation;

import java.io.File;
import java.util.Map;

/**
 * @author ghzj
 * @date 2021/1/18 21:25
 */
@TemplateAnnotation
public class AddOrUpdateVue implements ExecTemplate {

    @Override
    public String getTemplatePathValue() {
        return "null";
    }

    @Override
    public String getFilePathName(String packagePath, Map<String, Object> map) {
        String className = (String) map.get("className");
        String moduleName = (String) map.get("moduleName");
        return "main" + File.separator + "resources" + File.separator + "src" + File.separator + "views" + File.separator + "modules" +
                File.separator + moduleName + File.separator + className.toLowerCase() + "-add-or-update.vue";
    }
}
