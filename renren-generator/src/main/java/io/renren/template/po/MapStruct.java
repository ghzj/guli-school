package io.renren.template.po;

import io.renren.template.ExecTemplate;
import io.renren.template.FactoryClass;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
@FactoryClass
public class MapStruct implements ExecTemplate {

    @Override
    public String getFilePathName(String packagePath, Map<String, Object> map) {
        return getFileName(packagePath,map,"convert");
    }
}