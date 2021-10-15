package io.github.ghzj.guli.education.rpc.impl;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.VideoCodeConstants;
import io.github.ghzj.guli.education.convert.VideoMapStruct;
import io.github.ghzj.guli.education.entity.VideoEntity;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoListDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoUpdateDTO;
import io.github.ghzj.guli.education.object.view.video.VideoPageVO;
import io.github.ghzj.guli.education.object.view.video.VideoInfoVO;
import io.github.ghzj.guli.education.service.VideoService;
import io.github.ghzj.guli.education.rpc.VideoRpc;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
@DubboService(version = "1.0.0")
public class VideoRpcImpl implements VideoRpc {

    @Autowired
    private VideoService videoService;

    @Override
    public CommonResult<PageUtils<VideoPageVO>> pageVideo(VideoListDTO param){
        PageUtils<VideoEntity> page = videoService.queryPage(param);

        return CommonResult.success(VideoMapStruct.INSTANCE.P2GV(page));
    }

    @Override
    public CommonResult<VideoInfoVO> info(String id){
        VideoEntity video = videoService.getById(id);

        return CommonResult.success(VideoMapStruct.INSTANCE.P2IV(video));
    }

    @Override
    public CommonResult<Boolean> save(VideoSaveDTO param){
        boolean flag = videoService.save(VideoMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(VideoCodeConstants.EDUCATION_VIDEO_SAVE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> update(VideoUpdateDTO param){
        boolean flag = videoService.updateById(VideoMapStruct.INSTANCE.DTO2P(param));
        if (!flag){
            throw ServiceExceptionUtil.exception(VideoCodeConstants.EDUCATION_VIDEO_UPDATE_ERROR);
        }
        return CommonResult.success(flag);
    }

    @Override
    public CommonResult<Boolean> delete(String[] ids){
        boolean flag = videoService.removeByIds(Arrays.asList(ids));
        if (!flag){
            throw ServiceExceptionUtil.exception(VideoCodeConstants.EDUCATION_VIDEO_DELETE_ERROR);
        }
        return CommonResult.success(flag);
    }

}