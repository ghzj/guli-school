package io.github.ghzj.guli.education.object.transfer.data.teacher;

import io.github.ghzj.guli.common.vo.OrderParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherListDTO extends OrderParam {
    //讲师ID
    private String id;
    //讲师姓名
    private String name;
    //讲师简介
    private String intro;
    //讲师资历,一句话说明讲师
    private String career;
    //头衔 1高级讲师 2首席讲师
    private Integer level;
    //讲师头像
    private String avatar;
    //排序
    private Integer sort;
    //逻辑删除 1（true）已删除， 0（false）未删除
    private Integer isDeleted;
    //创建时间
    private Date gmtCreate;
    //更新时间
    private Date gmtModified;
}