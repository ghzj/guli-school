package io.github.ghzj.generator.aspect;

import java.lang.annotation.*;

/**
 * @author ghzj
 * @date 2021/1/15 21:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ErrorCodeAnnotation {
}
