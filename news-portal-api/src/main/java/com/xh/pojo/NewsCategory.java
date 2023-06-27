package com.xh.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 新闻分类表(NewsCategory)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 09:13:40
 */
@SuppressWarnings("serial")
public class NewsCategory extends Model<NewsCategory> {

    private Integer id;
    //分类名称
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

