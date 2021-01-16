package io.renren.template;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
@Documented
public @interface FactoryClass {
}