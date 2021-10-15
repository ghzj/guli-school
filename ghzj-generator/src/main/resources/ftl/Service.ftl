package ${packagePath}.${moduleName}.${ServicePath};

import com.baomidou.mybatisplus.extension.service.IService;
import ${mainPath}.common.utils.PageUtils;
import ${packagePath}.${moduleName}.${EntityPath}.${className}${EntityName};
import ${packagePath}.${moduleName}.${ListDTOPath}.${packageName}.${className}${ListDTOName};

import java.util.Map;

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
public interface ${className}${ServiceName} extends IService<${className}${EntityName}> {

    PageUtils<${className}${EntityName}> queryPage(${className}${ListDTOName} params);
}