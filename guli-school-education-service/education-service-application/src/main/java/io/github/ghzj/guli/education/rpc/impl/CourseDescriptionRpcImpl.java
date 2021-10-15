package io.github.ghzj.guli.education.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.CourseDescriptionCodeConstants;
import io.github.ghzj.guli.education.convert.CourseDescriptionMapStruct;
import io.github.ghzj.guli.education.entity.CourseDescriptionEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.description.CourseDescriptionPageVO;
import io.github.ghzj.guli.education.object.view.course.description.CourseDescriptionInfoVO;
import io.github.ghzj.guli.education.service.CourseDescriptionService;
import io.github.ghzj.guli.education.rpc.CourseDescriptionRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@DubboService(version = "1.0.0")
public class CourseDescriptionRpcImpl implements CourseDescriptionRpc {

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Override
    public CommonResult<PageUtils<CourseDescriptionPageVO>> pageCourseDescription(CourseDescriptionListDTO param){
        PageUtils<CourseDescriptionEntity> page = courseDescriptionService.queryPage(param);

        return CommonResult.success(CourseDescriptionMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<CourseDescriptionInfoVO> info(String id){
        CourseDescriptionEntity courseDescription = courseDescriptionService.getById(id);

        return CommonResult.success(CourseDescriptionMapStruct.INSTANCE.P2IV(courseDescription));
    }

    @Override
    public CommonResult<Boolean> save(CourseDescriptionSaveDTO param){
        boolean flag = courseDescriptionService.save(CourseDescriptionMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseDescriptionCodeConstants.EDUCATION_COURSE_DESCRIPTION_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(CourseDescriptionUpdateDTO param){
        boolean flag = courseDescriptionService.updateById(CourseDescriptionMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseDescriptionCodeConstants.EDUCATION_COURSE_DESCRIPTION_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = courseDescriptionService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseDescriptionCodeConstants.EDUCATION_COURSE_DESCRIPTION_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}