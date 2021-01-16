package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.exception.util.ServiceExceptionUtil;
import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.common.vo.CommonResult;
import io.github.ghzj.guli.education.constant.EducationCodeConstants;
import io.github.ghzj.guli.education.convert.eduteacher.EduTeacherMapStruct;
import io.github.ghzj.guli.education.entity.EduTeacherEntity;
import io.github.ghzj.guli.education.object.transfer.data.eduteacher.ListEduTeacherDTO;
import io.github.ghzj.guli.education.object.transfer.data.eduteacher.SaveEduTeacherDTO;
import io.github.ghzj.guli.education.object.transfer.data.teacher.ListTeacherDTO;
import io.github.ghzj.guli.education.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("讲师 API")
@Slf4j
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("分页查询")
    public CommonResult<PageUtils> list(@RequestBody @Validated ListEduTeacherDTO listEduTeacherDTO){
        PageUtils page = eduTeacherService.queryPage(listEduTeacherDTO);
        return CommonResult.success(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public CommonResult<EduTeacherEntity> info(@PathVariable("id") String id){
		EduTeacherEntity eduTeacher = eduTeacherService.getById(id);

        return CommonResult.success(eduTeacher);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加老师")
    public CommonResult<Boolean> save(@RequestBody SaveEduTeacherDTO saveEduTeacherDTO){

        boolean flag = eduTeacherService.save(EduTeacherMapStruct.INSTANCE.DTO2P(saveEduTeacherDTO));
        if (!flag){
            throw ServiceExceptionUtil.exception(EducationCodeConstants.EDUCATION_TEACHER_SAVE_ERROR);
        }
        return CommonResult.success(true);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public CommonResult<Boolean> update(@RequestBody EduTeacherEntity eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (!flag){
            throw ServiceExceptionUtil.exception(EducationCodeConstants.EDUCATION_TEACHER_UPDATE_ERROR);
        }
        return CommonResult.success(true);
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
