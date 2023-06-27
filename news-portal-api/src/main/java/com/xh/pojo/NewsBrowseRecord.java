package com.xh.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 新闻列表查看记录表(NewsBrowseRecord)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 09:13:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_news_browse_record")
public class NewsBrowseRecord {

    private Integer id;
    //新闻id
    private Integer newsId;
    //用户id
    private Integer userId;
    //创建时间
    private Date createTime;


}

