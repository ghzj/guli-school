package io.github.ghzj.generator.template.po;

import io.github.ghzj.generator.template.ExecTemplate;
import io.github.ghzj.generator.template.TemplateAnnotation;

import java.util.Map;

/**
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021/3/8 19:36:30
 */
@TemplateAnnotation
public class PageVO implements ExecTemplate {

    @Override
    public String getFilePathName(String packagePath, Map<String, Object> map) {
        return getDTOFileName(packagePath, map);
    }

    @Override
    public String getTemplatePathValue() {
        return "object.view";
    }
}
