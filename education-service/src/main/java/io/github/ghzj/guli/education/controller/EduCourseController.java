package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.education.entity.EduCourseEntity;
import io.github.ghzj.guli.education.service.EduCourseService;
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
@RequestMapping("education/educourse")
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("education:educourse:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eduCourseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("education:educourse:info")
    public R info(@PathVariable("id") String id){
		EduCourseEntity eduCourse = eduCourseService.getById(id);

        return R.ok().put("eduCourse", eduCourse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("education:educourse:save")
    public R save(@RequestBody EduCourseEntity eduCourse){
		eduCourseService.save(eduCourse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("education:educourse:update")
    public R update(@RequestBody EduCourseEntity eduCourse){
		eduCourseService.updateById(eduCourse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("education:educourse:delete")
    public R delete(@RequestBody String[] ids){
		eduCourseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
