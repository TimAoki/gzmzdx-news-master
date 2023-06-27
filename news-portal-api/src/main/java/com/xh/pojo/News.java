package com.xh.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻表(News)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 21:04:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//表名映射
@TableName("tb_news")
@SuppressWarnings("serial")
public class News extends Model<News> {

    private Integer id;
    //新闻标题
    private String title;
    //所属分类
    private Integer categoryId;
    //正文内容
    private String content;
    //作者
    private String author;
    //状态（0:待审核 1:已审核 2:已发布）
    private Integer status;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //浏览量
    private Integer browseCount;

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

