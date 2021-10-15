package io.github.ghzj.guli.management.controller.education;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherListDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.TeacherUpdateDTO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherPageVO;
import io.github.ghzj.guli.education.object.view.teacher.TeacherInfoVO;
import io.github.ghzj.guli.education.rpc.TeacherRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Api("讲师 API")
@RestController
@RequestMapping("education/teacher")
public class TeacherRpcController {

    @DubboReference(version = "1.0.0")
    private TeacherRpc teacherRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<TeacherPageVO>> list(@RequestBody @Validated TeacherListDTO param){
        CommonResult<PageUtils<TeacherPageVO>> page = teacherRpc.pageTeacher(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询讲师信息")
    public CommonResult<TeacherInfoVO> info(@PathVariable("id") String id){
        CommonResult<TeacherInfoVO> info = teacherRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加讲师")
    public CommonResult<Boolean> save(@RequestBody TeacherSaveDTO param){
        CommonResult<Boolean> save = teacherRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新讲师")
    public CommonResult<Boolean> update(@RequestBody TeacherUpdateDTO param){
        CommonResult<Boolean> update = teacherRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除讲师")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = teacherRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







