package ${packagePath}.${moduleName}.${MapStructPath};

import ${packagePath}.${moduleName}.${EntityPath}.${className}${EntityName};
import ${packagePath}.${moduleName}.${SaveDTOPath}.${packageName}.${className}${SaveDTOName};
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
}
