package com.xh.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 新闻分类表(NewsCategory)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 09:13:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_news_category")
public class NewsCategory {

    private Integer id;
    //分类名称
    private String name;


}

