package io.github.ghzj.guli.education.rpc;

import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoListDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoSaveDTO;
import io.github.ghzj.guli.education.object.transfer.data.video.VideoUpdateDTO;
import io.github.ghzj.guli.education.object.view.video.VideoPageVO;
import io.github.ghzj.guli.education.object.view.video.VideoInfoVO;

/**
 * 课程视频 Rpc 接口
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:13
 */
public interface VideoRpc {

    /**
     * 课程视频 列表
     * @param param param
     * @return 分页数据，返回null表示没数据
     */
    CommonResult<PageUtils<VideoPageVO>> pageVideo(VideoListDTO param);


    /**
     * 课程视频 信息
     * @param id id
     * @return 获取信息，返回null表示没数据
     */
    CommonResult<VideoInfoVO> info(String id);

    /**
     * 课程视频 保存
     * @param param param
     * @return 保存，保存不成功会返回错误代码
     */
    CommonResult<Boolean> save(VideoSaveDTO param);

    /**
     * 课程视频 修改
     * @param param param
     * @return 修改，修改不成功会返回错误代码
     */
    CommonResult<Boolean> update(VideoUpdateDTO param);

    /**
     * 课程视频 删除
     * @param param id列表
     * @return 删除，删除不成功会返回错误代码
     */
    CommonResult<Boolean> delete(String[] ids);

}