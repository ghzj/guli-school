package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.entity.EduTeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.teacher.ListTeacherDTO;
import io.github.ghzj.guli.education.service.EduTeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 讲师
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@RestController
@RequestMapping("education/eduteacher")
@Slf4j
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("education:eduteacher:list")
//    public CommonResult<PageUtils> list(@RequestParam Map<String, Object> params){
    public CommonResult<PageUtils> list(@Validated ListTeacherDTO listTeacherDTO){
        PageUtils page = eduTeacherService.queryPage(listTeacherDTO);
        return CommonResult.success(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("education:eduteacher:info")
    public R info(@PathVariable("id") String id){
		EduTeacherEntity eduTeacher = eduTeacherService.getById(id);

        return R.ok().put("eduTeacher", eduTeacher);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("education:eduteacher:save")
    public R save(@RequestBody EduTeacherEntity eduTeacher){
		eduTeacherService.save(eduTeacher);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("education:eduteacher:update")
    public R update(@RequestBody EduTeacherEntity eduTeacher){
		eduTeacherService.updateById(eduTeacher);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("education:eduteacher:delete")
    public CommonResult<Boolean> delete(@RequestBody String[] ids){
		eduTeacherService.removeByIds(Arrays.asList(ids));

        return CommonResult.success(true);
    }

}
