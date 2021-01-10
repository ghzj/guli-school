package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.education.entity.EduCourseDescriptionEntity;
import io.github.ghzj.guli.education.service.EduCourseDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 课程简介
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@RestController
@RequestMapping("education/educoursedescription")
public class EduCourseDescriptionController {
    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("education:educoursedescription:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eduCourseDescriptionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("education:educoursedescription:info")
    public R info(@PathVariable("id") String id){
		EduCourseDescriptionEntity eduCourseDescription = eduCourseDescriptionService.getById(id);

        return R.ok().put("eduCourseDescription", eduCourseDescription);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("education:educoursedescription:save")
    public R save(@RequestBody EduCourseDescriptionEntity eduCourseDescription){
		eduCourseDescriptionService.save(eduCourseDescription);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("education:educoursedescription:update")
    public R update(@RequestBody EduCourseDescriptionEntity eduCourseDescription){
		eduCourseDescriptionService.updateById(eduCourseDescription);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("education:educoursedescription:delete")
    public R delete(@RequestBody String[] ids){
		eduCourseDescriptionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
