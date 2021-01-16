package ${packagePath}.${moduleName}.${DaoPath};

import ${packagePath}.${moduleName}.${EntityPath}.${className}${EntityName};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
@Mapper
public interface ${className}${DaoName} extends BaseMapper<${className}${EntityName}> {

}