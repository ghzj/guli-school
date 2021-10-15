package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.CoursePageVO;
import io.github.ghzj.guli.education.object.view.course.CourseInfoVO;

/**
 * 课程 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface CourseRpc {

    /**
     * 课程 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<CoursePageVO>> pageCourse(CourseListDTO param);


    /**
     * 课程 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<CourseInfoVO> info(String id);

    /**
     * 课程 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(CourseSaveDTO param);

    /**
     * 课程 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(CourseUpdateDTO param);

    /**
     * 课程 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] ids);

}