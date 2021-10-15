package io.github.ghzj.guli.education.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.CourseCollectCodeConstants;
import io.github.ghzj.guli.education.convert.CourseCollectMapStruct;
import io.github.ghzj.guli.education.entity.CourseCollectEntity;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.collect.CourseCollectPageVO;
import io.github.ghzj.guli.education.object.view.course.collect.CourseCollectInfoVO;
import io.github.ghzj.guli.education.service.CourseCollectService;
import io.github.ghzj.guli.education.rpc.CourseCollectRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@DubboService(version = "1.0.0")
public class CourseCollectRpcImpl implements CourseCollectRpc {

    @Autowired
    private CourseCollectService courseCollectService;

    @Override
    public CommonResult<PageUtils<CourseCollectPageVO>> pageCourseCollect(CourseCollectListDTO param){
        PageUtils<CourseCollectEntity> page = courseCollectService.queryPage(param);

        return CommonResult.success(CourseCollectMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<CourseCollectInfoVO> info(String id){
        CourseCollectEntity courseCollect = courseCollectService.getById(id);

        return CommonResult.success(CourseCollectMapStruct.INSTANCE.P2IV(courseCollect));
    }

    @Override
    public CommonResult<Boolean> save(CourseCollectSaveDTO param){
        boolean flag = courseCollectService.save(CourseCollectMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCollectCodeConstants.EDUCATION_COURSE_COLLECT_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(CourseCollectUpdateDTO param){
        boolean flag = courseCollectService.updateById(CourseCollectMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCollectCodeConstants.EDUCATION_COURSE_COLLECT_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = courseCollectService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCollectCodeConstants.EDUCATION_COURSE_COLLECT_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}