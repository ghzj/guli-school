package io.github.ghzj.guli.education.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ghzj.guli.education.entity.CommentEntity;
import io.github.ghzj.guli.education.service.CommentService;
import io.github.ghzj.guli.common.utils.PageUtils;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentListDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentUpdateDTO;
import io.github.ghzj.guli.education.convert.CommentMapStruct;
import io.github.ghzj.guli.education.constant.CommentCodeConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-18 19:36:30
 */
@Api("评论 API")
@RestController
@RequestMapping("education/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
    * 列表
    */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated CommentListDTO param){
        PageUtils page = commentService.queryPage(param);

        return CommonResult.success(page);
    }

    /**
    * 信息
    */
    @GetMapping("/info/{id}")
    @ApiOperation("查询评论信息")
    public CommonResult<CommentEntity> info(@PathVariable("id") String id){
        CommentEntity comment = commentService.getById(id);

        return CommonResult.success(comment);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加评论")
    public CommonResult<Boolean> save(@RequestBody CommentSaveDTO param){

        boolean flag = commentService.save(CommentMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CommentCodeConstants.EDUCATION_COMMENT_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 修改
    */
    @PutMapping("/update")
    @ApiOperation("更新评论")
    public CommonResult<Boolean> update(@RequestBody CommentUpdateDTO param){
        boolean flag = commentService.updateById(CommentMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CommentCodeConstants.EDUCATION_COMMENT_UPDATE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete")
    @ApiOperation("删除评论")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
        boolean flag = commentService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(CommentCodeConstants.EDUCATION_COMMENT_DELETE_ERROR);
        }
        return CommonResult.success(true);
    }

}