package io.github.ghzj.guli.education.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.ChapterCodeConstants;
import io.github.ghzj.guli.education.convert.ChapterMapStruct;
import io.github.ghzj.guli.education.entity.ChapterEntity;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterListDTO;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterUpdateDTO;
import io.github.ghzj.guli.education.object.view.chapter.ChapterPageVO;
import io.github.ghzj.guli.education.object.view.chapter.ChapterInfoVO;
import io.github.ghzj.guli.education.service.ChapterService;
import io.github.ghzj.guli.education.rpc.ChapterRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
@DubboService(version = "1.0.0")
public class ChapterRpcImpl implements ChapterRpc {

    @Autowired
    private ChapterService chapterService;

    @Override
    public CommonResult<PageUtils<ChapterPageVO>> pageChapter(ChapterListDTO param){
        PageUtils<ChapterEntity> page = chapterService.queryPage(param);

        return CommonResult.success(ChapterMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<ChapterInfoVO> info(String id){
        ChapterEntity chapter = chapterService.getById(id);

        return CommonResult.success(ChapterMapStruct.INSTANCE.P2IV(chapter));
    }

    @Override
    public CommonResult<Boolean> save(ChapterSaveDTO param){
        boolean flag = chapterService.save(ChapterMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(ChapterCodeConstants.EDUCATION_CHAPTER_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(ChapterUpdateDTO param){
        boolean flag = chapterService.updateById(ChapterMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(ChapterCodeConstants.EDUCATION_CHAPTER_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = chapterService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(ChapterCodeConstants.EDUCATION_CHAPTER_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}