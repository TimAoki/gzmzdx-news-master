package com.xh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.mapper.NewsBrowseRecordMapper;
import com.xh.pojo.NewsBrowseRecord;
import com.xh.service.NewsBrowseRecordService;
import org.springframework.stereotype.Service;

/**
 * 新闻列表查看记录表(NewsBrowseRecord)表服务实现类
 *
 * @author 徐海
 * @since 2023-06-26 21:13:52
 */
@Service("newsBrowseRecordService")
public class NewsBrowseRecordServiceImpl extends ServiceImpl<NewsBrowseRecordMapper, NewsBrowseRecord> implements NewsBrowseRecordService {

}

