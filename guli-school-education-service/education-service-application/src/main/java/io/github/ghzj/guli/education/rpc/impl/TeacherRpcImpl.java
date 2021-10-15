package io.github.ghzj.guli.education.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.TeacherCodeConstants;
import io.github.ghzj.guli.education.convert.TeacherMapStruct;
import io.github.ghzj.guli.education.entity.TeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherUpdateDTO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherPageVO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherInfoVO;
import io.github.ghzj.guli.education.service.TeacherService;
import io.github.ghzj.guli.education.rpc.TeacherRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@DubboService(version = "1.0.0")
public class TeacherRpcImpl implements TeacherRpc {

    @Autowired
    private TeacherService teacherService;

    @Override
    public CommonResult<PageUtils<TeacherPageVO>> pageTeacher(TeacherListDTO param){
        PageUtils<TeacherEntity> page = teacherService.queryPage(param);

        return CommonResult.success(TeacherMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<TeacherInfoVO> info(String id){
        TeacherEntity teacher = teacherService.getById(id);

        return CommonResult.success(TeacherMapStruct.INSTANCE.P2IV(teacher));
    }

    @Override
    public CommonResult<Boolean> save(TeacherSaveDTO param){
        boolean flag = teacherService.save(TeacherMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(TeacherCodeConstants.EDUCATION_TEACHER_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(TeacherUpdateDTO param){
        boolean flag = teacherService.updateById(TeacherMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(TeacherCodeConstants.EDUCATION_TEACHER_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = teacherService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(TeacherCodeConstants.EDUCATION_TEACHER_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}