package ${packagePath}.${moduleName}.${RpcPath};

import ${packagePath}.common.vo.CommonResult;
import ${packagePath}.common.utils.PageUtils;
import ${packagePath}.${moduleName}.${ListDTOPath}.${packageName}.${className}${ListDTOName};
import ${packagePath}.${moduleName}.${SaveDTOPath}.${packageName}.${className}${SaveDTOName};
import ${packagePath}.${moduleName}.${UpdateDTOPath}.${packageName}.${className}${UpdateDTOName};
import ${packagePath}.${moduleName}.${PageVOPath}.${packageName}.${className}${PageVOName};
import ${packagePath}.${moduleName}.${InfoVOPath}.${packageName}.${className}${InfoVOName};

/**
 * ${tableComment} Rpc 接口
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
public interface ${className}${RpcName} {

    /**
     * ${tableComment} 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult${r"<"}PageUtils${r"<"}${className}${PageVOName}>> page${className}(${className}${ListDTOName} param);


    /**
     * ${tableComment} 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult${r"<"}${className}${InfoVOName}> info(${pk.attrType} ${pk.humpAttrName});

    /**
     * ${tableComment} 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult${r"<"}Boolean> save(${className}${SaveDTOName} param);

    /**
     * ${tableComment} 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult${r"<"}Boolean> update(${className}${UpdateDTOName} param);

    /**
     * ${tableComment} 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult${r"<"}Boolean> delete(${pk.attrType}[] ${pk.humpAttrName}s);

}