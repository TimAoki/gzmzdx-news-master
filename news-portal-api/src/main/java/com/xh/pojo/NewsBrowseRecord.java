package com.xh.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻列表查看记录表(NewsBrowseRecord)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 09:13:40
 */
@SuppressWarnings("serial")
public class NewsBrowseRecord extends Model<NewsBrowseRecord> {

    private Integer id;
    //新闻id
    private Integer newsId;
    //用户id
    private Integer userId;
    //创建时间
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

