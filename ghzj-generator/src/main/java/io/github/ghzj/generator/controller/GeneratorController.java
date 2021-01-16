package io.github.ghzj.generator.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ghzj.generator.aspect.ErrorCodeAnnotation;
import io.github.ghzj.generator.entity.TablesEntity;
import io.github.ghzj.generator.service.GeneratorService;
import io.github.ghzj.generator.service.TablesService;
import io.github.ghzj.generator.utils.PageUtils;
import io.github.ghzj.generator.utils.R;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
@Controller
@RequestMapping("/sys/generator")
public class GeneratorController {

    @Autowired
    private TablesService tablesService;

    @Autowired
    private GeneratorService generatorService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){

        String page =  (String)params.get("page");
        String limit =  (String)params.get("limit");
        String tableName = (String) params.get("tableName");
        QueryWrapper<TablesEntity> wrapper = new QueryWrapper<TablesEntity>()
//                .eq("table_schema", "guli_education")
                .like(tableName!=null && !"".equals(tableName),"table_name",tableName)
                .orderByDesc("create_time");

        PageUtils pageUtil = new PageUtils(tablesService.page(new Page<TablesEntity>(Long.parseLong(page), Long.parseLong(limit)), wrapper));

        return R.ok().put("page", pageUtil);
    }

    /**
     * 生成代码
     */
    @RequestMapping("/code")
    @ErrorCodeAnnotation
    public void code(String tables, HttpServletResponse response) throws IOException {
        byte[] data = generatorService.generatorCode(tables.split(","));

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"renren.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
