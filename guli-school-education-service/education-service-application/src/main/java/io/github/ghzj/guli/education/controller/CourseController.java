package io.github.ghzj.guli.education.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ghzj.guli.education.entity.CourseEntity;
import io.github.ghzj.guli.education.service.CourseService;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseUpdateDTO;
import io.github.ghzj.guli.education.convert.CourseMapStruct;
import io.github.ghzj.guli.education.constant.CourseCodeConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Api("课程 API")
@RestController
@RequestMapping("education/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated CourseListDTO param){
        PageUtils page = courseService.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程信息")
    public CommonResult<CourseEntity> info(@PathVariable("id") String id){
        CourseEntity course = courseService.getById(id);

        return CommonResult.success(course);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程")
    public CommonResult<Boolean> save(@RequestBody CourseSaveDTO param){

        boolean flag = courseService.save(CourseMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCodeConstants.EDUCATION_COURSE_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    @ApiOperation("更新课程")
    public CommonResult<Boolean> update(@RequestBody CourseUpdateDTO param){
        boolean flag = courseService.updateById(CourseMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCodeConstants.EDUCATION_COURSE_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        boolean flag = courseService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCodeConstants.EDUCATION_COURSE_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}