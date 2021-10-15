package io.github.ghzj.guli.management.controller.education;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseListDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.course.CourseUpdateDTO;
import io.github.ghzj.guli.education.object.view.course.CoursePageVO;
import io.github.ghzj.guli.education.object.view.course.CourseInfoVO;
import io.github.ghzj.guli.education.rpc.CourseRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Api("课程 API")
@RestController
@RequestMapping("education/course")
public class CourseRpcController {

    @DubboReference(version = "1.0.0")
    private CourseRpc courseRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<CoursePageVO>> list(@RequestBody @Validated CourseListDTO param){
        CommonResult<PageUtils<CoursePageVO>> page = courseRpc.pageCourse(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程信息")
    public CommonResult<CourseInfoVO> info(@PathVariable("id") String id){
        CommonResult<CourseInfoVO> info = courseRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程")
    public CommonResult<Boolean> save(@RequestBody CourseSaveDTO param){
        CommonResult<Boolean> save = courseRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新课程")
    public CommonResult<Boolean> update(@RequestBody CourseUpdateDTO param){
        CommonResult<Boolean> update = courseRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = courseRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







