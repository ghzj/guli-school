package io.github.ghzj.generator.template.po;

import io.github.ghzj.generator.template.ExecTemplate;
import io.github.ghzj.generator.template.TemplateAnnotation;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
@TemplateAnnotation
public class MapStruct implements ExecTemplate {

    @Override
    public String getTemplatePathValue() {
        return "convert";
    }
}