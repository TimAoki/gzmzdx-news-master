package com.xh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.pojo.NewsAuditRecord;
import com.xh.service.NewsAuditRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 新闻审核记录表(NewsAuditRecord)表控制层
 *
 * @author 徐海
 * @since 2023-06-26 21:14:32
 */
@RestController
@RequestMapping("newsAuditRecord")
public class NewsAuditRecordController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NewsAuditRecordService newsAuditRecordService;

    /**
     * 分页查询所有数据
     *
     * @param page            分页对象
     * @param newsAuditRecord 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<NewsAuditRecord> page, NewsAuditRecord newsAuditRecord) {
        return success(this.newsAuditRecordService.page(page, new QueryWrapper<>(newsAuditRecord)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.newsAuditRecordService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param newsAuditRecord 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody NewsAuditRecord newsAuditRecord) {
        return success(this.newsAuditRecordService.save(newsAuditRecord));
    }

    /**
     * 修改数据
     *
     * @param newsAuditRecord 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody NewsAuditRecord newsAuditRecord) {
        return success(this.newsAuditRecordService.updateById(newsAuditRecord));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.newsAuditRecordService.removeByIds(idList));
    }
}

