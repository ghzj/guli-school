package io.github.ghzj.generator.template.po;

import io.github.ghzj.generator.template.ExecTemplate;
import io.github.ghzj.generator.template.TemplateAnnotation;

/**
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021/3/8 19:36:30
 */
@TemplateAnnotation
public class RpcImpl implements ExecTemplate {
    @Override
    public String getTemplatePathValue() {
        return "rpc.impl";
    }
}