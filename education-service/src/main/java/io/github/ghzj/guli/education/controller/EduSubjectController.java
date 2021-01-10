package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.education.entity.EduSubjectEntity;
import io.github.ghzj.guli.education.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 课程科目
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@RestController
@RequestMapping("education/edusubject")
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("education:edusubject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eduSubjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("education:edusubject:info")
    public R info(@PathVariable("id") String id){
		EduSubjectEntity eduSubject = eduSubjectService.getById(id);

        return R.ok().put("eduSubject", eduSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("education:edusubject:save")
    public R save(@RequestBody EduSubjectEntity eduSubject){
		eduSubjectService.save(eduSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("education:edusubject:update")
    public R update(@RequestBody EduSubjectEntity eduSubject){
		eduSubjectService.updateById(eduSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("education:edusubject:delete")
    public R delete(@RequestBody String[] ids){
		eduSubjectService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
