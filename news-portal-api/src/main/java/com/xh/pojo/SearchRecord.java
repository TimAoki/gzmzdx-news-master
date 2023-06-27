package com.xh.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 搜索记录表(SearchRecord)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 21:17:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_search_record")
@SuppressWarnings("serial")
public class SearchRecord extends Model<SearchRecord> {

    private Integer id;
    //搜索关键字
    private String keyword;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

