package com.xh.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xh.pojo.User;

/**
 * 用户表(User)表服务接口
 *
 * @author 徐海
 * @since 2023-06-26 14:08:15
 */
public interface UserService extends IService<User> {
    User findUserByUsername(String username);

    //    List<User> list();
    User test();
}

