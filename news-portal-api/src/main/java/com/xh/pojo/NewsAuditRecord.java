package com.xh.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


/**
 * 新闻审核记录表(NewsAuditRecord)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 09:13:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_news_audit_record")
public class NewsAuditRecord {

    private Integer id;
    //新闻id
    private Integer newsId;
    //审核员id
    private Integer auditorId;
    //审核状态（0:未通过 1:已通过）
    private Integer auditStatus;
    //审核意见
    private String auditOpinion;
    //创建时间
    private LocalDate createTime;


}

