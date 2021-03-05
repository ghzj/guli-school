package io.github.ghzj.guli.education.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ghzj.guli.education.entity.ChapterEntity;
import io.github.ghzj.guli.education.service.ChapterService;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterListDTO;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterUpdateDTO;
import io.github.ghzj.guli.education.convert.ChapterMapStruct;
import io.github.ghzj.guli.education.constant.ChapterCodeConstants;
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
@RequestMapping("education/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated ChapterListDTO param){
        PageUtils page = chapterService.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程信息")
    public CommonResult<ChapterEntity> info(@PathVariable("id") String id){
        ChapterEntity chapter = chapterService.getById(id);

        return CommonResult.success(chapter);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程")
    public CommonResult<Boolean> save(@RequestBody ChapterSaveDTO param){

        boolean flag = chapterService.save(ChapterMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(ChapterCodeConstants.EDUCATION_CHAPTER_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    @ApiOperation("更新课程")
    public CommonResult<Boolean> update(@RequestBody ChapterUpdateDTO param){
        boolean flag = chapterService.updateById(ChapterMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(ChapterCodeConstants.EDUCATION_CHAPTER_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        boolean flag = chapterService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(ChapterCodeConstants.EDUCATION_CHAPTER_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}