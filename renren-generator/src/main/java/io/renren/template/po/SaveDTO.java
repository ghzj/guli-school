package io.renren.template.po;

import io.renren.template.ExecTemplate;
import io.renren.template.FactoryClass;
import java.util.Map;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
@FactoryClass
public class SaveDTO implements ExecTemplate {
    @Override
    public String getFilePathName(String packagePath, Map<String, Object> map) {
        return getDTOFileName(packagePath, map, "DTO");
    }
}