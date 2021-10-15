package io.github.ghzj.guli.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.education.entity.ChapterEntity;
import io.github.ghzj.guli.education.object.transfer.data.chapter.ChapterListDTO;

import java.util.Map;

/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-08-05 02:30:14
 */
public interface ChapterService extends IService<ChapterEntity> {

    PageUtils<ChapterEntity> queryPage(ChapterListDTO params);
}