package com.xh.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.mapper.CommentMapper;
import com.xh.mapper.UserMapper;
import com.xh.pojo.Comment;
import com.xh.pojo.User;
import com.xh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author 徐海
 * @since 2023-06-26 14:08:15
 */
//@Service("userService")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {

        return userMapper.findUserByUsername(username);
    }

    @Override
    public User test() {
        UserMapper userMapper = getBaseMapper();
        List<Comment> comments = commentMapper.selectList(null);
        User user = userMapper.selectById(1);
        //查询用户对应的订单
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 1);
        List<Comment> commentList = commentMapper.selectList(wrapper);
        return user;
    }
}

