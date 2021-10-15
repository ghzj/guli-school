package io.github.ghzj.guli.management.controller.education;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectListDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.subject.SubjectUpdateDTO;
import io.github.ghzj.guli.education.object.view.subject.SubjectPageVO;
import io.github.ghzj.guli.education.object.view.subject.SubjectInfoVO;
import io.github.ghzj.guli.education.rpc.SubjectRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@Api("课程科目 API")
@RestController
@RequestMapping("education/subject")
public class SubjectRpcController {

    @DubboReference(version = "1.0.0")
    private SubjectRpc subjectRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<SubjectPageVO>> list(@RequestBody @Validated SubjectListDTO param){
        CommonResult<PageUtils<SubjectPageVO>> page = subjectRpc.pageSubject(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程科目信息")
    public CommonResult<SubjectInfoVO> info(@PathVariable("id") String id){
        CommonResult<SubjectInfoVO> info = subjectRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程科目")
    public CommonResult<Boolean> save(@RequestBody SubjectSaveDTO param){
        CommonResult<Boolean> save = subjectRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新课程科目")
    public CommonResult<Boolean> update(@RequestBody SubjectUpdateDTO param){
        CommonResult<Boolean> update = subjectRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程科目")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = subjectRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







