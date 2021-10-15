package io.github.ghzj.guli.education.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.SubjectCodeConstants;
import io.github.ghzj.guli.education.convert.SubjectMapStruct;
import io.github.ghzj.guli.education.entity.SubjectEntity;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectListDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectUpdateDTO;
import io.github.ghzj.guli.education.object.view.subject.SubjectPageVO;
import io.github.ghzj.guli.education.object.view.subject.SubjectInfoVO;
import io.github.ghzj.guli.education.service.SubjectService;
import io.github.ghzj.guli.education.rpc.SubjectRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@DubboService(version = "1.0.0")
public class SubjectRpcImpl implements SubjectRpc {

    @Autowired
    private SubjectService subjectService;

    @Override
    public CommonResult<PageUtils<SubjectPageVO>> pageSubject(SubjectListDTO param){
        PageUtils<SubjectEntity> page = subjectService.queryPage(param);

        return CommonResult.success(SubjectMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<SubjectInfoVO> info(String id){
        SubjectEntity subject = subjectService.getById(id);

        return CommonResult.success(SubjectMapStruct.INSTANCE.P2IV(subject));
    }

    @Override
    public CommonResult<Boolean> save(SubjectSaveDTO param){
        boolean flag = subjectService.save(SubjectMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(SubjectCodeConstants.EDUCATION_SUBJECT_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(SubjectUpdateDTO param){
        boolean flag = subjectService.updateById(SubjectMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(SubjectCodeConstants.EDUCATION_SUBJECT_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = subjectService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(SubjectCodeConstants.EDUCATION_SUBJECT_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}