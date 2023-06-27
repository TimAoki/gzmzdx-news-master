package com.xh.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 评论表(Comment)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 09:13:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_comment")
public class Comment {

    private Integer id;
    //新闻id
    private Integer newsId;
    //父评论id
    private Integer parentId;
    //用户id
    private Integer userId;
    //评论内容
    private String content;
    //创建时间
    private Date createTime;
    //用户名
//    private String username;


}

