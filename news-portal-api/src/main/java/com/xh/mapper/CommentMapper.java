package com.xh.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.pojo.Comment;


/**
 * 评论表(Comment)表数据库访问层
 *
 * @author 徐海
 * @since 2023-06-26 09:13:38
 */
public interface CommentMapper extends BaseMapper<Comment> {

    //多表分页查询
    IPage<Comment> findAllComments(Page<Comment> page);
}
