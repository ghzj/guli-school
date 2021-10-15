package ${packagePath}.${moduleName}.${RpcImplPath};

import ${packagePath}.common.exception.util.ServiceExceptionUtil;
import ${packagePath}.common.utils.PageUtils;
import ${packagePath}.common.vo.CommonResult;
import ${packagePath}.${moduleName}.${CodeConstantsPath}.${className}${CodeConstantsName};
import ${packagePath}.${moduleName}.${MapStructPath}.${className}${MapStructName};
import ${packagePath}.${moduleName}.${EntityPath}.${className}${EntityName};
import ${packagePath}.${moduleName}.${ListDTOPath}.${packageName}.${className}${ListDTOName};
import ${packagePath}.${moduleName}.${SaveDTOPath}.${packageName}.${className}${SaveDTOName};
import ${packagePath}.${moduleName}.${UpdateDTOPath}.${packageName}.${className}${UpdateDTOName};
import ${packagePath}.${moduleName}.${PageVOPath}.${packageName}.${className}${PageVOName};
import ${packagePath}.${moduleName}.${InfoVOPath}.${packageName}.${className}${InfoVOName};
import ${packagePath}.${moduleName}.${ServicePath}.${className}${ServiceName};
import ${packagePath}.${moduleName}.${RpcPath}.${className}${RpcName};
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
@DubboService(version = "1.0.0")
public class ${className}${RpcImplName} implements ${className}${RpcName} {

    @Autowired
    private ${className}${ServiceName} ${humpClassName}${ServiceName};

    @Override
    public CommonResult${r"<"}PageUtils${r"<"}${className}${PageVOName}>> page${className}(${className}${ListDTOName} param){
        PageUtils<${className}${EntityName}> page = ${humpClassName}${ServiceName}.queryPage(param);

        return CommonResult.success(${className}${MapStructName}.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult${r"<"}${className}${InfoVOName}> info(${pk.attrType} ${pk.humpAttrName}){
        ${className}${EntityName} ${humpClassName} = ${humpClassName}${ServiceName}.getById(${pk.humpAttrName});

        return CommonResult.success(${className}${MapStructName}.INSTANCE.P2IV(${humpClassName}));
    }

    @Override
    public CommonResult${r"<"}Boolean> save(${className}${SaveDTOName} param){
        boolean flag = ${humpClassName}${ServiceName}.save(${className}${MapStructName}.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(${className}${CodeConstantsName}.${tableNameToUpperCase}_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult${r"<"}Boolean> update(${className}${UpdateDTOName} param){
        boolean flag = ${humpClassName}${ServiceName}.updateById(${className}${MapStructName}.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(${className}${CodeConstantsName}.${tableNameToUpperCase}_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult${r"<"}Boolean> delete(${pk.attrType}[] ${pk.humpAttrName}s){
        boolean flag = ${humpClassName}${ServiceName}.removeByIds(Arrays.asList(${pk.humpAttrName}s));
        if (!flag){
            throw ServiceExceptionUtil.exception(${className}${CodeConstantsName}.${tableNameToUpperCase}_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}