package io.github.ghzj.guli.education.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ghzj.guli.education.entity.SubjectEntity;
import io.github.ghzj.guli.education.service.SubjectService;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectListDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectUpdateDTO;
import io.github.ghzj.guli.education.convert.SubjectMapStruct;
import io.github.ghzj.guli.education.constant.SubjectCodeConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;

/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Api("课程科目 API")
@RestController
@RequestMapping("education/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated SubjectListDTO param){
        PageUtils page = subjectService.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程科目信息")
    public CommonResult<SubjectEntity> info(@PathVariable("id") String id){
        SubjectEntity subject = subjectService.getById(id);

        return CommonResult.success(subject);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程科目")
    public CommonResult<Boolean> save(@RequestBody SubjectSaveDTO param){

        boolean flag = subjectService.save(SubjectMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(SubjectCodeConstants.EDUCATION_SUBJECT_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    @ApiOperation("更新课程科目")
    public CommonResult<Boolean> update(@RequestBody SubjectUpdateDTO param){
        boolean flag = subjectService.updateById(SubjectMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(SubjectCodeConstants.EDUCATION_SUBJECT_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程科目")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        boolean flag = subjectService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(SubjectCodeConstants.EDUCATION_SUBJECT_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}