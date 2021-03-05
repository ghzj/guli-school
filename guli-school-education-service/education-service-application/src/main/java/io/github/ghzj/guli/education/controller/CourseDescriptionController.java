package io.github.ghzj.guli.education.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ghzj.guli.education.entity.CourseDescriptionEntity;
import io.github.ghzj.guli.education.service.CourseDescriptionService;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionUpdateDTO;
import io.github.ghzj.guli.education.convert.CourseDescriptionMapStruct;
import io.github.ghzj.guli.education.constant.CourseDescriptionCodeConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;

/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Api("课程简介 API")
@RestController
@RequestMapping("education/coursedescription")
public class CourseDescriptionController {
    @Autowired
    private CourseDescriptionService courseDescriptionService;

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated CourseDescriptionListDTO param){
        PageUtils page = courseDescriptionService.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程简介信息")
    public CommonResult<CourseDescriptionEntity> info(@PathVariable("id") String id){
        CourseDescriptionEntity courseDescription = courseDescriptionService.getById(id);

        return CommonResult.success(courseDescription);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程简介")
    public CommonResult<Boolean> save(@RequestBody CourseDescriptionSaveDTO param){

        boolean flag = courseDescriptionService.save(CourseDescriptionMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseDescriptionCodeConstants.EDUCATION_COURSE_DESCRIPTION_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    @ApiOperation("更新课程简介")
    public CommonResult<Boolean> update(@RequestBody CourseDescriptionUpdateDTO param){
        boolean flag = courseDescriptionService.updateById(CourseDescriptionMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseDescriptionCodeConstants.EDUCATION_COURSE_DESCRIPTION_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程简介")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        boolean flag = courseDescriptionService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseDescriptionCodeConstants.EDUCATION_COURSE_DESCRIPTION_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}