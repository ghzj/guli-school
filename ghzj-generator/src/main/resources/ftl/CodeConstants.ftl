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

    ErrorCode ${tableNameToUpperCase}_SAVE_ERROR = new ErrorCode(${errorCode?c}, "${tableComment}添加失败");
    ErrorCode ${tableNameToUpperCase}_UPDATE_ERROR = new ErrorCode(${(errorCode+1)?c}, "${tableComment}更新失败");
    ErrorCode ${tableNameToUpperCase}_DELETE_ERROR = new ErrorCode(${ (errorCode+2)?c}, "${tableComment}删除失败");
}