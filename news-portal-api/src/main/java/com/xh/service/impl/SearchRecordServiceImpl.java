package com.xh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.mapper.SearchRecordMapper;
import com.xh.pojo.SearchRecord;
import com.xh.service.SearchRecordService;
import org.springframework.stereotype.Service;

/**
 * 搜索记录表(SearchRecord)表服务实现类
 *
 * @author 徐海
 * @since 2023-06-26 21:17:34
 */
@Service("searchRecordService")
public class SearchRecordServiceImpl extends ServiceImpl<SearchRecordMapper, SearchRecord> implements SearchRecordService {

}

