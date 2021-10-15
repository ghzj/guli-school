package io.github.ghzj.guli.management.controller.education;

import java.util.Arrays;
import java.util.Map;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentListDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentUpdateDTO;
import io.github.ghzj.guli.education.object.view.comment.CommentPageVO;
import io.github.ghzj.guli.education.object.view.comment.CommentInfoVO;
import io.github.ghzj.guli.education.rpc.CommentRpc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
@Api("评论 API")
@RestController
@RequestMapping("education/comment")
public class CommentRpcController {

    @DubboReference(version = "1.0.0")
    private CommentRpc commentRpc;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils<CommentPageVO>> list(@RequestBody @Validated CommentListDTO param){
        CommonResult<PageUtils<CommentPageVO>> page = commentRpc.pageComment(param);
        page.checkError();
        return CommonResult.success(page.getData());
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("查询评论信息")
    public CommonResult<CommentInfoVO> info(@PathVariable("id") String id){
        CommonResult<CommentInfoVO> info = commentRpc.info(id);
        info.checkError();
        return CommonResult.success(info.getData());
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加评论")
    public CommonResult<Boolean> save(@RequestBody CommentSaveDTO param){
        CommonResult<Boolean> save = commentRpc.save(param);
        save.checkError();
        return CommonResult.success(save.getData());
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("更新评论")
    public CommonResult<Boolean> update(@RequestBody CommentUpdateDTO param){
        CommonResult<Boolean> update = commentRpc.update(param);
        update.checkError();
        return CommonResult.success(update.getData());
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除评论")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        CommonResult<Boolean> delete = commentRpc.delete(ids);
        delete.checkError();
        return CommonResult.success(delete.getData());
    }

}







