package io.github.ghzj.guli.education.controller;

import io.github.ghzj.guli.common.utils.PageUtils;
import io.github.ghzj.guli.common.utils.R;
import io.github.ghzj.guli.education.entity.EduCommentEntity;
import io.github.ghzj.guli.education.service.EduCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 评论
 *
 * @author ghzj
 * @email xxxxxxx@qq.com
 * @date 2021-01-10 01:11:57
 */
@RestController
@RequestMapping("education/educomment")
public class EduCommentController {
    @Autowired
    private EduCommentService eduCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("education:educomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eduCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("education:educomment:info")
    public R info(@PathVariable("id") String id){
		EduCommentEntity eduComment = eduCommentService.getById(id);

        return R.ok().put("eduComment", eduComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("education:educomment:save")
    public R save(@RequestBody EduCommentEntity eduComment){
		eduCommentService.save(eduComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("education:educomment:update")
    public R update(@RequestBody EduCommentEntity eduComment){
		eduCommentService.updateById(eduComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("education:educomment:delete")
    public R delete(@RequestBody String[] ids){
		eduCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
