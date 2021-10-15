package io.github.ghzj.guli.management.controller.education;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.description.CourseDescriptionUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.description.CourseDescriptionPageVO;
import io.github.ghzj.guli.education.object.view.course.description.CourseDescriptionInfoVO;
import io.github.ghzj.guli.education.rpc.CourseDescriptionRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Api("课程简介 API")
@RestController
@RequestMapping("education/coursedescription")
public class CourseDescriptionRpcController {

    @DubboReference(version = "1.0.0")
    private CourseDescriptionRpc courseDescriptionRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<CourseDescriptionPageVO>> list(@RequestBody @Validated CourseDescriptionListDTO param){
        CommonResult<PageUtils<CourseDescriptionPageVO>> page = courseDescriptionRpc.pageCourseDescription(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程简介信息")
    public CommonResult<CourseDescriptionInfoVO> info(@PathVariable("id") String id){
        CommonResult<CourseDescriptionInfoVO> info = courseDescriptionRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程简介")
    public CommonResult<Boolean> save(@RequestBody CourseDescriptionSaveDTO param){
        CommonResult<Boolean> save = courseDescriptionRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新课程简介")
    public CommonResult<Boolean> update(@RequestBody CourseDescriptionUpdateDTO param){
        CommonResult<Boolean> update = courseDescriptionRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程简介")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = courseDescriptionRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







