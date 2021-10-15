package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.collect.CourseCollectPageVO;
import io.github.ghzj.guli.education.object.view.course.collect.CourseCollectInfoVO;

/**
 * 课程收藏 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface CourseCollectRpc {

    /**
     * 课程收藏 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<CourseCollectPageVO>> pageCourseCollect(CourseCollectListDTO param);


    /**
     * 课程收藏 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<CourseCollectInfoVO> info(String id);

    /**
     * 课程收藏 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(CourseCollectSaveDTO param);

    /**
     * 课程收藏 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(CourseCollectUpdateDTO param);

    /**
     * 课程收藏 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] ids);

}