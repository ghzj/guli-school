package io.github.ghzj.guli.education.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ghzj.guli.education.entity.VideoEntity;
import io.github.ghzj.guli.education.service.VideoService;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoListDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoUpdateDTO;
import io.github.ghzj.guli.education.convert.VideoMapStruct;
import io.github.ghzj.guli.education.constant.VideoCodeConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Api("课程视频 API")
@RestController
@RequestMapping("education/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated VideoListDTO param){
        PageUtils page = videoService.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程视频信息")
    public CommonResult<VideoEntity> info(@PathVariable("id") String id){
        VideoEntity video = videoService.getById(id);

        return CommonResult.success(video);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程视频")
    public CommonResult<Boolean> save(@RequestBody VideoSaveDTO param){

        boolean flag = videoService.save(VideoMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(VideoCodeConstants.EDUCATION_VIDEO_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    @ApiOperation("更新课程视频")
    public CommonResult<Boolean> update(@RequestBody VideoUpdateDTO param){
        boolean flag = videoService.updateById(VideoMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(VideoCodeConstants.EDUCATION_VIDEO_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程视频")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        boolean flag = videoService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(VideoCodeConstants.EDUCATION_VIDEO_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}