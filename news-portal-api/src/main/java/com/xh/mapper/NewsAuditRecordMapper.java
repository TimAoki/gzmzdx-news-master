package com.xh.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.xh.pojo.NewsAuditRecord;

/**
 * 新闻审核记录表(NewsAuditRecord)表数据库访问层
 *
 * @author 徐海
 * @since 2023-06-26 21:14:33
 */
public interface NewsAuditRecordMapper extends BaseMapper<NewsAuditRecord> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<NewsAuditRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<NewsAuditRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<NewsAuditRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<NewsAuditRecord> entities);

}

