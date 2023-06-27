package com.xh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.mapper.NewsAuditRecordMapper;
import com.xh.pojo.NewsAuditRecord;
import com.xh.service.NewsAuditRecordService;
import org.springframework.stereotype.Service;

/**
 * 新闻审核记录表(NewsAuditRecord)表服务实现类
 *
 * @author 徐海
 * @since 2023-06-26 21:14:33
 */
@Service("newsAuditRecordService")
public class NewsAuditRecordServiceImpl extends ServiceImpl<NewsAuditRecordMapper, NewsAuditRecord> implements NewsAuditRecordService {

}

