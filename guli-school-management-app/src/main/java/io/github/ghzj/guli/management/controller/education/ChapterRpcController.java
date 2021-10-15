package io.github.ghzj.guli.management.controller.education;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterListDTO;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterUpdateDTO;
import io.github.ghzj.guli.education.object.view.chapter.ChapterPageVO;
import io.github.ghzj.guli.education.object.view.chapter.ChapterInfoVO;
import io.github.ghzj.guli.education.rpc.ChapterRpc;
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
 * @date 2021-08-05 02:30:14
 */
@Api("课程 API")
@RestController
@RequestMapping("education/chapter")
public class ChapterRpcController {

    @DubboReference(version = "1.0.0")
    private ChapterRpc chapterRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<ChapterPageVO>> list(@RequestBody @Validated ChapterListDTO param){
        CommonResult<PageUtils<ChapterPageVO>> page = chapterRpc.pageChapter(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询课程信息")
    public CommonResult<ChapterInfoVO> info(@PathVariable("id") String id){
        CommonResult<ChapterInfoVO> info = chapterRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加课程")
    public CommonResult<Boolean> save(@RequestBody ChapterSaveDTO param){
        CommonResult<Boolean> save = chapterRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新课程")
    public CommonResult<Boolean> update(@RequestBody ChapterUpdateDTO param){
        CommonResult<Boolean> update = chapterRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除课程")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = chapterRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







