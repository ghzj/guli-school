package ${packagePath}.${moduleName}.${MapStructPath};

import ${packagePath}.${moduleName}.${EntityPath}.${className}${EntityName};
import ${packagePath}.${moduleName}.${SaveDTOPath}.${packageName}.${className}${SaveDTOName};
import ${packagePath}.${moduleName}.${UpdateDTOPath}.${packageName}.${className}${UpdateDTOName};
import ${packagePath}.${moduleName}.${PageVOPath}.${packageName}.${className}${PageVOName};
import ${packagePath}.${moduleName}.${InfoVOPath}.${packageName}.${className}${InfoVOName};
import ${packagePath}.common.utils.PageUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
@Mapper
public interface  ${className}${MapStructName} {
    ${className}${MapStructName} INSTANCE = Mappers.getMapper(${className}${MapStructName}.class);

    /**
    * @param param ${className}${SaveDTOName}
    * @return DTO2P
    */
    ${className}${EntityName} DTO2P(${className}${SaveDTOName} param);

    /**
    * @param param ${className}${UpdateDTOName}
    * @return DTO2P
    */
    ${className}${EntityName} DTO2P(${className}${UpdateDTOName} param);

    /**
     * @param param ${className}${EntityName}
     * @return P2IV
     */
    ${className}${InfoVOName} P2IV(${className}${EntityName} param);

    /**
     * @param param ${className}${EntityName}
     * @return P2GV
     */
    ${className}${PageVOName} P2GV(${className}${EntityName} param);

    /**
     * @param param ${className}${EntityName}
     * @return P2GV
     */
    List<${className}${PageVOName}> P2GV(List<${className}${EntityName}> param);

    /**
     * @param param ${className}${EntityName}
     * @return P2GV
     */
    PageUtils<${className}${PageVOName}> P2GV(PageUtils<${className}${EntityName}> param);
}
