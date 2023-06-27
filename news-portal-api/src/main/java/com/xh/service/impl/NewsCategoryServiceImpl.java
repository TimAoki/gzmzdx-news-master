package com.xh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.mapper.NewsCategoryMapper;
import com.xh.pojo.NewsCategory;
import com.xh.service.NewsCategoryService;
import org.springframework.stereotype.Service;

/**
 * 新闻分类表(NewsCategory)表服务实现类
 *
 * @author 徐海
 * @since 2023-06-26 21:16:19
 */
@Service("newsCategoryService")
public class NewsCategoryServiceImpl extends ServiceImpl<NewsCategoryMapper, NewsCategory> implements NewsCategoryService {

}

