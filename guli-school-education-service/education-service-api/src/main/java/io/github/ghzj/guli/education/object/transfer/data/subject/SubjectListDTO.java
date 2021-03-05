package io.github.ghzj.guli.education.object.transfer.data.subject;

import io.github.ghzj.guli.common.vo.OrderParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@ApiModel("课程科目 分页 Request DTO")
public class SubjectListDTO extends OrderParam {
    //课程类别ID
    @ApiModelProperty(value = "课程类别ID")
    private String id;
    //类别名称
    @ApiModelProperty(value = "类别名称")
    private String title;
    //父ID
    @ApiModelProperty(value = "父ID")
    private String parentId;
    //排序字段
    @ApiModelProperty(value = "排序字段")
    private Integer sort;
    //创建时间
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
    //更新时间
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
}