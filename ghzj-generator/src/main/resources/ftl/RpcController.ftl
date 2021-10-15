package ${packagePath}.${moduleName}.${RpcControllerPath};

import java.util.Arrays;
import java.util.Map;

import ${packagePath}.common.vo.CommonResult;
import ${packagePath}.common.utils.PageUtils;
import ${packagePath}.${moduleName}.${ListDTOPath}.${packageName}.${className}${ListDTOName};
import ${packagePath}.${moduleName}.${SaveDTOPath}.${packageName}.${className}${SaveDTOName};
import ${packagePath}.${moduleName}.${UpdateDTOPath}.${packageName}.${className}${UpdateDTOName};
import ${packagePath}.${moduleName}.${PageVOPath}.${packageName}.${className}${PageVOName};
import ${packagePath}.${moduleName}.${InfoVOPath}.${packageName}.${className}${InfoVOName};
import ${packagePath}.${moduleName}.${RpcPath}.${className}${RpcName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
public class ${className}${RpcControllerName} {

    @DubboReference(version = "1.0.0")
    private ${className}${RpcName} ${humpClassName}${RpcName};

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult${r"<"}PageUtils${r"<"}${className}${PageVOName}>> list(@RequestBody @Validated ${className}${ListDTOName} param){
        CommonResult${r"<"}PageUtils${r"<"}${className}${PageVOName}>> page = ${humpClassName}${RpcName}.page${className}(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{${pk.humpAttrName}}")
    @ApiOperation("查询${tableComment}信息")
    public CommonResult${r"<"}${className}${InfoVOName}> info(@PathVariable("${pk.humpAttrName}") ${pk.attrType} ${pk.humpAttrName}){
        CommonResult${r"<"}${className}${InfoVOName}> info = ${humpClassName}${RpcName}.info(${pk.humpAttrName});
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加${tableComment}")
    public CommonResult${r"<"}Boolean> save(@RequestBody ${className}${SaveDTOName} param){
        CommonResult${r"<"}Boolean> save = ${humpClassName}${RpcName}.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新${tableComment}")
    public CommonResult${r"<"}Boolean> update(@RequestBody ${className}${UpdateDTOName} param){
        CommonResult${r"<"}Boolean> update = ${humpClassName}${RpcName}.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除${tableComment}")
    public CommonResult${r"<"}Boolean> delete(@RequestBody ${pk.attrType}[] ${pk.humpAttrName}s){
        CommonResult${r"<"}Boolean> delete = ${humpClassName}${RpcName}.delete(${pk.humpAttrName}s);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







