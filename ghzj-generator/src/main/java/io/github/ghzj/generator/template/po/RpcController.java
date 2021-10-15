package io.github.ghzj.generator.template.po;

import io.github.ghzj.generator.template.ExecTemplate;
import io.github.ghzj.generator.template.TemplateAnnotation;

/**
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021/3/9 19:36:30
 */
@TemplateAnnotation
public class RpcController implements ExecTemplate {

    @Override
    public String getTemplatePathValue() {
        return "controller.rpc";
    }

}