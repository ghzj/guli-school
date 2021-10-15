package io.github.ghzj.guli.education.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.CommentCodeConstants;
import io.github.ghzj.guli.education.convert.CommentMapStruct;
import io.github.ghzj.guli.education.entity.CommentEntity;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentListDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentUpdateDTO;
import io.github.ghzj.guli.education.object.view.comment.CommentPageVO;
import io.github.ghzj.guli.education.object.view.comment.CommentInfoVO;
import io.github.ghzj.guli.education.service.CommentService;
import io.github.ghzj.guli.education.rpc.CommentRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
@DubboService(version = "1.0.0")
public class CommentRpcImpl implements CommentRpc {

    @Autowired
    private CommentService commentService;

    @Override
    public CommonResult<PageUtils<CommentPageVO>> pageComment(CommentListDTO param){
        PageUtils<CommentEntity> page = commentService.queryPage(param);

        return CommonResult.success(CommentMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<CommentInfoVO> info(String id){
        CommentEntity comment = commentService.getById(id);

        return CommonResult.success(CommentMapStruct.INSTANCE.P2IV(comment));
    }

    @Override
    public CommonResult<Boolean> save(CommentSaveDTO param){
        boolean flag = commentService.save(CommentMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CommentCodeConstants.EDUCATION_COMMENT_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(CommentUpdateDTO param){
        boolean flag = commentService.updateById(CommentMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(CommentCodeConstants.EDUCATION_COMMENT_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = commentService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(CommentCodeConstants.EDUCATION_COMMENT_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}