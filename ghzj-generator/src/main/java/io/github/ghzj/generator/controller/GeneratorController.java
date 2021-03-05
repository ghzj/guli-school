package io.github.ghzj.generator.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ghzj.generator.aspect.ErrorCodeAnnotation;
import io.github.ghzj.generator.entity.TablesEntity;
import io.github.ghzj.generator.entity.properties.GeneratorProperties;
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
import java.util.List;
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

    @Autowired
    private GeneratorProperties generatorProperties;

    /**
     * 分页列表
     */
    @ResponseBody
    @RequestMapping("/pageList")
    public R pageList(@RequestParam Map<String, Object> params){

        String page =  (String)params.get("page");
        String limit =  (String)params.get("limit");
        String tableName = (String) params.get("tableName");
        QueryWrapper<TablesEntity> wrapper = new QueryWrapper<TablesEntity>()
                .eq("table_schema", generatorProperties.getTableSchema())
                .like(tableName!=null && !"".equals(tableName),"table_name",tableName)
                .orderByDesc("create_time");

        PageUtils pageUtil = new PageUtils(tablesService.page(new Page<TablesEntity>(Long.parseLong(page), Long.parseLong(limit)), wrapper));

        return R.ok().put("page", pageUtil);
    }

    @ResponseBody
    @RequestMapping("/list")
    public R list(){

        QueryWrapper<TablesEntity> wrapper = new QueryWrapper<TablesEntity>()
                .eq("table_schema", generatorProperties.getTableSchema())
                .orderByDesc("create_time");

        List<TablesEntity> list = tablesService.list(wrapper);

        return R.ok().put("list", list);
    }

    /**
     * 生成代码
     */
    @RequestMapping("/code")
    @ErrorCodeAnnotation
    public void code(@RequestParam("tables") String tables, HttpServletResponse response) throws IOException {
        byte[] data = generatorService.generatorCode(tables.split(","));

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"renren.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
