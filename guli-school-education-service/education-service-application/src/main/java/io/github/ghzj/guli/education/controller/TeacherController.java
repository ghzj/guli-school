package io.github.ghzj.guli.education.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ghzj.guli.education.entity.TeacherEntity;
import io.github.ghzj.guli.education.service.TeacherService;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherUpdateDTO;
import io.github.ghzj.guli.education.convert.TeacherMapStruct;
import io.github.ghzj.guli.education.constant.TeacherCodeConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;

/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Api("讲师 API")
@RestController
@RequestMapping("education/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated TeacherListDTO param){
        PageUtils page = teacherService.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{id}")
    @ApiOperation("查询讲师信息")
    public CommonResult<TeacherEntity> info(@PathVariable("id") String id){
        TeacherEntity teacher = teacherService.getById(id);

        return CommonResult.success(teacher);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加讲师")
    public CommonResult<Boolean> save(@RequestBody TeacherSaveDTO param){

        boolean flag = teacherService.save(TeacherMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(TeacherCodeConstants.EDUCATION_TEACHER_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PostMapping("/update")
    @ApiOperation("更新讲师")
    public CommonResult<Boolean> update(@RequestBody TeacherUpdateDTO param){
        boolean flag = teacherService.updateById(TeacherMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(TeacherCodeConstants.EDUCATION_TEACHER_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除讲师")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        boolean flag = teacherService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(TeacherCodeConstants.EDUCATION_TEACHER_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}