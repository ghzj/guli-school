package io.github.ghzj.guli.management.controller.education;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoListDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoUpdateDTO;
import io.github.ghzj.guli.education.object.view.video.VideoPageVO;
import io.github.ghzj.guli.education.object.view.video.VideoInfoVO;
import io.github.ghzj.guli.education.rpc.VideoRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Api("课程视频 API")
@RestController
@RequestMapping("education/video")
public class VideoRpcController {

    @DubboReference(version = "1.0.0")
    private VideoRpc videoRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<VideoPageVO>> list(@RequestBody @Validated VideoListDTO param){
        CommonResult<PageUtils<VideoPageVO>> page = videoRpc.pageVideo(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程视频信息")
    public CommonResult<VideoInfoVO> info(@PathVariable("id") String id){
        CommonResult<VideoInfoVO> info = videoRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程视频")
    public CommonResult<Boolean> save(@RequestBody VideoSaveDTO param){
        CommonResult<Boolean> save = videoRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新课程视频")
    public CommonResult<Boolean> update(@RequestBody VideoUpdateDTO param){
        CommonResult<Boolean> update = videoRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程视频")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = videoRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







