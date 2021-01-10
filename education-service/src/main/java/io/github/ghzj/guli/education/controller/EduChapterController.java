package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.education.entity.EduChapterEntity;
import io.github.ghzj.guli.education.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 课程
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@RestController
@RequestMapping("education/educhapter")
public class EduChapterController {
    @Autowired
    private EduChapterService eduChapterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("education:educhapter:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eduChapterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("education:educhapter:info")
    public R info(@PathVariable("id") String id){
		EduChapterEntity eduChapter = eduChapterService.getById(id);

        return R.ok().put("eduChapter", eduChapter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("education:educhapter:save")
    public R save(@RequestBody EduChapterEntity eduChapter){
		eduChapterService.save(eduChapter);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("education:educhapter:update")
    public R update(@RequestBody EduChapterEntity eduChapter){
		eduChapterService.updateById(eduChapter);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("education:educhapter:delete")
    public R delete(@RequestBody String[] ids){
		eduChapterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
