package com.xh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.mapper.CommentMapper;
import com.xh.pojo.Comment;
import com.xh.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author 徐海
 * @since 2023-06-26 21:08:09
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}

