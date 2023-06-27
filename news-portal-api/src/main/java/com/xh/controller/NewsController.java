package com.xh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.pojo.News;
import com.xh.service.NewsService;
import com.xh.utils.Result;
import com.xh.utils.TokenResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 新闻表(News)表控制层
 *
 * @author 徐海
 * @since 2023-06-26 21:04:06
 */
@RestController
@RequestMapping("news")
public class NewsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;





    @GetMapping("list")
    public Result selectList() {
        List<News> list = newsService.list(null);
//        Map<String , List<News>> map = new HashMap<String ,List<News>>();
//        map.put("", list);
        return Result.buildResult(200,"成功",list);

    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param news 查询实体
     * @return 所有数据
     */


    @GetMapping
    public Result selectAll(Page<News> page, News news) {
        return Result.buildResult(Result.ok(),this.newsService.page(page, new QueryWrapper<>(news)));
//        return success(this.newsService.page(page, new QueryWrapper<>(news)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.newsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param news 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody News news) {
        return success(this.newsService.save(news));
    }

    /**
     * 修改数据
     *
     * @param news 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody News news) {
        return success(this.newsService.updateById(news));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.newsService.removeByIds(idList));
    }
}

