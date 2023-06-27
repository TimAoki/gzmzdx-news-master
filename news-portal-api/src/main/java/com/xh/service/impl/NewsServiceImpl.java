package com.xh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.mapper.NewsMapper;
import com.xh.pojo.News;
import com.xh.service.NewsService;
import org.springframework.stereotype.Service;

/**
 * 新闻表(News)表服务实现类
 *
 * @author 徐海
 * @since 2023-06-26 21:04:07
 */
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}

