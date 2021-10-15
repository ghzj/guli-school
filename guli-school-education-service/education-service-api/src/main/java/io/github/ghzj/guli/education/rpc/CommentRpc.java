package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentListDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.comment.CommentUpdateDTO;
import io.github.ghzj.guli.education.object.view.comment.CommentPageVO;
import io.github.ghzj.guli.education.object.view.comment.CommentInfoVO;

/**
 * 评论 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
public interface CommentRpc {

    /**
     * 评论 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<CommentPageVO>> pageComment(CommentListDTO param);


    /**
     * 评论 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<CommentInfoVO> info(String id);

    /**
     * 评论 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(CommentSaveDTO param);

    /**
     * 评论 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(CommentUpdateDTO param);

    /**
     * 评论 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] ids);

}