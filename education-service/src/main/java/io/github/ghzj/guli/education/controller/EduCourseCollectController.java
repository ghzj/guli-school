package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.education.entity.EduCourseCollectEntity;
import io.github.ghzj.guli.education.service.EduCourseCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 课程收藏
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@RestController
@RequestMapping("education/educoursecollect")
public class EduCourseCollectController {
    @Autowired
    private EduCourseCollectService eduCourseCollectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("education:educoursecollect:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eduCourseCollectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("education:educoursecollect:info")
    public R info(@PathVariable("id") String id){
		EduCourseCollectEntity eduCourseCollect = eduCourseCollectService.getById(id);

        return R.ok().put("eduCourseCollect", eduCourseCollect);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("education:educoursecollect:save")
    public R save(@RequestBody EduCourseCollectEntity eduCourseCollect){
		eduCourseCollectService.save(eduCourseCollect);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("education:educoursecollect:update")
    public R update(@RequestBody EduCourseCollectEntity eduCourseCollect){
		eduCourseCollectService.updateById(eduCourseCollect);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("education:educoursecollect:delete")
    public R delete(@RequestBody String[] ids){
		eduCourseCollectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
