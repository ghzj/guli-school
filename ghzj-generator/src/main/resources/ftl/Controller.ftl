package ${packagePath}.${moduleName}.${ControllerPath};

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ${packagePath}.${moduleName}.${EntityPath}.${className}${EntityName};
import ${packagePath}.${moduleName}.${ServicePath}.${className}${ServiceName};
import ${mainPath}.common.utils.PageUtils;
import ${mainPath}.common.utils.R;

import ${packagePath}.common.vo.CommonResult;
import ${packagePath}.common.utils.PageUtils;
import ${packagePath}.${moduleName}.${ListDTOPath}.${packageName}.${className}${ListDTOName};
import ${packagePath}.${moduleName}.${SaveDTOPath}.${packageName}.${className}${SaveDTOName};
import ${packagePath}.${moduleName}.${UpdateDTOPath}.${packageName}.${className}${UpdateDTOName};
import ${packagePath}.${moduleName}.${MapStructPath}.${className}${MapStructName};
import ${packagePath}.${moduleName}.${CodeConstantsPath}.${className}${CodeConstantsName};
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ${packagePath}.common.exception.util.ServiceExceptionUtil;

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
@Api("${tableComment} API")
@RestController
@RequestMapping("${moduleName}/${pathName}")
public class ${className}${ControllerName} {
    @Autowired
    private ${className}${ServiceName} ${humpClassName}${ServiceName};

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult${r"<"}PageUtils> list(@RequestBody @Validated ${className}${ListDTOName} param){
        PageUtils page = ${humpClassName}${ServiceName}.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{${pk.humpAttrName}}")
    @ApiOperation("查询${tableComment}信息")
    public CommonResult${r"<"}${className}${EntityName}> info(@PathVariable("${pk.humpAttrName}") ${pk.attrType} ${pk.humpAttrName}){
        ${className}${EntityName} ${humpClassName} = ${humpClassName}${ServiceName}.getById(${pk.humpAttrName});

        return CommonResult.success(${humpClassName});
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加${tableComment}")
    public CommonResult${r"<"}Boolean> save(@RequestBody ${className}${SaveDTOName} param){

        boolean flag = ${humpClassName}${ServiceName}.save(${className}${MapStructName}.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(${className}${CodeConstantsName}.${tableNameToUpperCase}_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    @ApiOperation("更新${tableComment}")
    public CommonResult${r"<"}Boolean> update(@RequestBody ${className}${UpdateDTOName} param){
        boolean flag = ${humpClassName}${ServiceName}.updateById(${className}${MapStructName}.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(${className}${CodeConstantsName}.${tableNameToUpperCase}_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除${tableComment}")
    public CommonResult${r"<"}Boolean> delete(@RequestBody ${pk.attrType}[] ${pk.humpAttrName}s){
        boolean flag = ${humpClassName}${ServiceName}.removeByIds(Arrays.asList(${pk.humpAttrName}s));
        if (!flag){
            throw ServiceExceptionUtil.exception(${className}${CodeConstantsName}.${tableNameToUpperCase}_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}