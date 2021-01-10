package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.education.entity.EduTeacherEntity;
import io.github.ghzj.guli.education.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@RestController
@RequestMapping("education/eduteacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("education:eduteacher:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eduTeacherService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("education:eduteacher:info")
    public R info(@PathVariable("id") String id){
		EduTeacherEntity eduTeacher = eduTeacherService.getById(id);

        return R.ok().put("eduTeacher", eduTeacher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("education:eduteacher:save")
    public R save(@RequestBody EduTeacherEntity eduTeacher){
		eduTeacherService.save(eduTeacher);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("education:eduteacher:update")
    public R update(@RequestBody EduTeacherEntity eduTeacher){
		eduTeacherService.updateById(eduTeacher);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("education:eduteacher:delete")
    public R delete(@RequestBody String[] ids){
		eduTeacherService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
