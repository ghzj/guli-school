package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.education.entity.EduVideoEntity;
import io.github.ghzj.guli.education.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 课程视频
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@RestController
@RequestMapping("education/eduvideo")
public class EduVideoController {
    @Autowired
    private EduVideoService eduVideoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("education:eduvideo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eduVideoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("education:eduvideo:info")
    public R info(@PathVariable("id") String id){
		EduVideoEntity eduVideo = eduVideoService.getById(id);

        return R.ok().put("eduVideo", eduVideo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("education:eduvideo:save")
    public R save(@RequestBody EduVideoEntity eduVideo){
		eduVideoService.save(eduVideo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("education:eduvideo:update")
    public R update(@RequestBody EduVideoEntity eduVideo){
		eduVideoService.updateById(eduVideo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("education:eduvideo:delete")
    public R delete(@RequestBody String[] ids){
		eduVideoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
