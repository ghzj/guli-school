package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.description.CourseDescriptionPageVO;
import io.github.ghzj.guli.education.object.view.course.description.CourseDescriptionInfoVO;

/**
 * 课程简介 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface CourseDescriptionRpc {

    /**
     * 课程简介 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<CourseDescriptionPageVO>> pageCourseDescription(CourseDescriptionListDTO param);


    /**
     * 课程简介 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<CourseDescriptionInfoVO> info(String id);

    /**
     * 课程简介 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(CourseDescriptionSaveDTO param);

    /**
     * 课程简介 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(CourseDescriptionUpdateDTO param);

    /**
     * 课程简介 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] ids);

}