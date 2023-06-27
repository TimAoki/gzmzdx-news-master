package com.xh.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.xh.pojo.NewsBrowseRecord;

/**
 * 新闻列表查看记录表(NewsBrowseRecord)表数据库访问层
 *
 * @author 徐海
 * @since 2023-06-26 21:13:52
 */
public interface NewsBrowseRecordMapper extends BaseMapper<NewsBrowseRecord> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<NewsBrowseRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<NewsBrowseRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<NewsBrowseRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<NewsBrowseRecord> entities);

}

