package io.github.ghzj.generator.template.po;

import io.github.ghzj.generator.template.ExecTemplate;
import io.github.ghzj.generator.template.TemplateAnnotation;


/**
 * @author ghzj
 * @date 2021/1/15 21:25
 */
@TemplateAnnotation
public class Controller implements ExecTemplate {

    @Override
    public String getTemplatePathValue() {
        return "controller";
    }
}
