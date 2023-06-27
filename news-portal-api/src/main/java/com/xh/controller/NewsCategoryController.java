package com.xh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.pojo.NewsCategory;
import com.xh.service.NewsCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 新闻分类表(NewsCategory)表控制层
 *
 * @author 徐海
 * @since 2023-06-26 21:16:18
 */
@RestController
@RequestMapping("newsCategory")
public class NewsCategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NewsCategoryService newsCategoryService;

    /**
     * 分页查询所有数据
     *
     * @param page         分页对象
     * @param newsCategory 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<NewsCategory> page, NewsCategory newsCategory) {
        return success(this.newsCategoryService.page(page, new QueryWrapper<>(newsCategory)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.newsCategoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param newsCategory 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody NewsCategory newsCategory) {
        return success(this.newsCategoryService.save(newsCategory));
    }

    /**
     * 修改数据
     *
     * @param newsCategory 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody NewsCategory newsCategory) {
        return success(this.newsCategoryService.updateById(newsCategory));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.newsCategoryService.removeByIds(idList));
    }
}

