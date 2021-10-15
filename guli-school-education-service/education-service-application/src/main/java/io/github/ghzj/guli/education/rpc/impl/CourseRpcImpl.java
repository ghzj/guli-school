package io.github.ghzj.guli.education.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.CourseCodeConstants;
import io.github.ghzj.guli.education.convert.CourseMapStruct;
import io.github.ghzj.guli.education.entity.CourseEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.CoursePageVO;
import io.github.ghzj.guli.education.object.view.course.CourseInfoVO;
import io.github.ghzj.guli.education.service.CourseService;
import io.github.ghzj.guli.education.rpc.CourseRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@DubboService(version = "1.0.0")
public class CourseRpcImpl implements CourseRpc {

    @Autowired
    private CourseService courseService;

    @Override
    public CommonResult<PageUtils<CoursePageVO>> pageCourse(CourseListDTO param){
        PageUtils<CourseEntity> page = courseService.queryPage(param);

        return CommonResult.success(CourseMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<CourseInfoVO> info(String id){
        CourseEntity course = courseService.getById(id);

        return CommonResult.success(CourseMapStruct.INSTANCE.P2IV(course));
    }

    @Override
    public CommonResult<Boolean> save(CourseSaveDTO param){
        boolean flag = courseService.save(CourseMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCodeConstants.EDUCATION_COURSE_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(CourseUpdateDTO param){
        boolean flag = courseService.updateById(CourseMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCodeConstants.EDUCATION_COURSE_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = courseService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCodeConstants.EDUCATION_COURSE_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}