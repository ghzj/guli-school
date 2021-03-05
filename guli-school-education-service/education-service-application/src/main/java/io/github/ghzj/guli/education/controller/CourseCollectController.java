package io.github.ghzj.guli.education.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ghzj.guli.education.entity.CourseCollectEntity;
import io.github.ghzj.guli.education.service.CourseCollectService;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectUpdateDTO;
import io.github.ghzj.guli.education.convert.CourseCollectMapStruct;
import io.github.ghzj.guli.education.constant.CourseCollectCodeConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;

/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Api("课程收藏 API")
@RestController
@RequestMapping("education/coursecollect")
public class CourseCollectController {
    @Autowired
    private CourseCollectService courseCollectService;

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated CourseCollectListDTO param){
        PageUtils page = courseCollectService.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程收藏信息")
    public CommonResult<CourseCollectEntity> info(@PathVariable("id") String id){
        CourseCollectEntity courseCollect = courseCollectService.getById(id);

        return CommonResult.success(courseCollect);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程收藏")
    public CommonResult<Boolean> save(@RequestBody CourseCollectSaveDTO param){

        boolean flag = courseCollectService.save(CourseCollectMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCollectCodeConstants.EDUCATION_COURSE_COLLECT_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    @ApiOperation("更新课程收藏")
    public CommonResult<Boolean> update(@RequestBody CourseCollectUpdateDTO param){
        boolean flag = courseCollectService.updateById(CourseCollectMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCollectCodeConstants.EDUCATION_COURSE_COLLECT_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程收藏")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        boolean flag = courseCollectService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(CourseCollectCodeConstants.EDUCATION_COURSE_COLLECT_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}