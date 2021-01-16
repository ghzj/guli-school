package io.github.ghzj.guli.education.object.transfer.data.eduteacher;

import io.github.ghzj.guli.common.vo.OrderParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-12 19:32:27
 */
@Data
@ApiModel("讲师 分页 Request DTO")
public class ListEduTeacherDTO extends OrderParam {


    //头衔 1高级讲师 2首席讲师
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;
    //讲师姓名
    @ApiModelProperty(value = "教师名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
    /*
    //讲师ID
    @ApiModelProperty(value = "讲师ID")
    private String id;
    //讲师简介
    @ApiModelProperty(value = "讲师简介")
    private String intro;
    //讲师资历,一句话说明讲师
    @ApiModelProperty(value = "讲师资历,一句话说明讲师")
    private String career;

    //讲师头像
    @ApiModelProperty(value = "讲师头像")
    private String avatar;
    //排序
    @ApiModelProperty(value = "排序")
    private Integer sort;
    //逻辑删除 1（true）已删除， 0（false）未删除
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;
    //创建时间
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    //更新时间
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
*/
}