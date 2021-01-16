package io.github.ghzj.generator.template;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
@Documented
public @interface TemplateAnnotation {
}