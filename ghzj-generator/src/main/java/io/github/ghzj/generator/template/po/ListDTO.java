package io.github.ghzj.generator.template.po;



import io.github.ghzj.generator.template.ExecTemplate;
import io.github.ghzj.generator.template.TemplateAnnotation;

import java.util.Map;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
@TemplateAnnotation
public class ListDTO implements ExecTemplate {

    @Override
    public String getFilePathName(String packagePath, Map<String, Object> map) {
        return getDTOFileName(packagePath, map);
    }

    @Override
    public String getTemplatePathValue() {
        return "object.transfer.data";
    }
}
