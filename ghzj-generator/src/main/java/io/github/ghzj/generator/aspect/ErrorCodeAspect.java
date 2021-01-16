package io.github.ghzj.generator.aspect;

import io.github.ghzj.generator.entity.TablesEntity;
import io.github.ghzj.generator.entity.properties.GeneratorProperties;
import io.github.ghzj.generator.service.TablesService;
import io.github.ghzj.generator.utils.GeneratorPropertiesUtils;
import org.apache.commons.configuration.Configuration;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ghzj
 * @date 2021/1/15 21:25
 */
@Aspect
@Component
public class ErrorCodeAspect {

    @Autowired
    private TablesService tablesService;

    @Autowired
    private GeneratorProperties generatorProperties;

    @Pointcut("@annotation(io.github.ghzj.generator.aspect.ErrorCodeAnnotation)")
    public void errorCodePointCut() {

    }

    @Around("errorCodePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        int code = Integer.parseInt(generatorProperties.getBaseErrorCode());
        List<TablesEntity> list = tablesService.queryList();
        for (TablesEntity tablesEntity : list) {
            map.put(tablesEntity.getTableName(),code++ * 1000);
        }
        ErrorCodeContextHolder.setContext(new ErrorCodeContext().setErrorCode(map));

        //执行方法
        Object result = point.proceed();

        ErrorCodeContextHolder.clear();
        return result;
    }

}
