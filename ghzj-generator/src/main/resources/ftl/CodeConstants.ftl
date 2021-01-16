package ${packagePath}.${moduleName}.${CodeConstantsPath};

import ${packagePath}.common.exception.ErrorCode;

/**
 * ${tableComment}
 *
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
public interface ${className}${CodeConstantsName} {

    ErrorCode ${tableNameToUpperCase}_SAVE_ERROR = new ErrorCode(${errorCode}, "${tableComment}添加失败");
    ErrorCode ${tableNameToUpperCase}_UPDATE_ERROR = new ErrorCode(${errorCode+1}, "${tableComment}更新失败");
}