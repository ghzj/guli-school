package io.github.ghzj.guli.management.controller.education;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.collect.CourseCollectUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.collect.CourseCollectPageVO;
import io.github.ghzj.guli.education.object.view.course.collect.CourseCollectInfoVO;
import io.github.ghzj.guli.education.rpc.CourseCollectRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Api("课程收藏 API")
@RestController
@RequestMapping("education/coursecollect")
public class CourseCollectRpcController {

    @DubboReference(version = "1.0.0")
    private CourseCollectRpc courseCollectRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<CourseCollectPageVO>> list(@RequestBody @Validated CourseCollectListDTO param){
        CommonResult<PageUtils<CourseCollectPageVO>> page = courseCollectRpc.pageCourseCollect(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程收藏信息")
    public CommonResult<CourseCollectInfoVO> info(@PathVariable("id") String id){
        CommonResult<CourseCollectInfoVO> info = courseCollectRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程收藏")
    public CommonResult<Boolean> save(@RequestBody CourseCollectSaveDTO param){
        CommonResult<Boolean> save = courseCollectRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新课程收藏")
    public CommonResult<Boolean> update(@RequestBody CourseCollectUpdateDTO param){
        CommonResult<Boolean> update = courseCollectRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程收藏")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = courseCollectRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







