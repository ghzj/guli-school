package ${packagePath}.${moduleName}.${ServiceImplPath};

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${mainPath}.common.utils.PageUtils;
import ${mainPath}.common.utils.Query;

import ${packagePath}.${moduleName}.${DaoPath}.${className}${DaoName};
import ${packagePath}.${moduleName}.${EntityPath}.${className}${EntityName};
import ${packagePath}.${moduleName}.${ServicePath}.${className}${ServiceName};
import ${packagePath}.${moduleName}.${ListDTOPath}.${packageName}.${className}${ListDTOName};

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
@Service("${humpClassName}${ServiceName}")
public class ${className}${ServiceImplName} extends ServiceImpl<${className}${DaoName}, ${className}${EntityName}> implements ${className}${ServiceName} {

    @Override
    public PageUtils queryPage(${className}${ListDTOName} params) {
        IPage<${className}${EntityName}> page = this.page(
            new Query<${className}${EntityName}>().getPage(params),
            new QueryWrapper<${className}${EntityName}>());

        return new PageUtils(page);
    }

}