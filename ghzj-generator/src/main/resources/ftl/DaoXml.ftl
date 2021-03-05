<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${packagePath}.${moduleName}.${DaoPath}.${className}${DaoName}">

    <!-- 可根据自己的需求，是否要使用 -->
    <resultMap type="${packagePath}.${moduleName}.${EntityPath}.${className}${EntityName}" id="${humpClassName}Map">
        <#list columns as column>
        <result property="${column.humpAttrName}" column="${column.columnName}"/>
        </#list>
    </resultMap>


</mapper>