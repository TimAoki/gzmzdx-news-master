package com.xh.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xh.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表(User)表数据库访问层
 *
 * @author 徐海
 * @since 2023-06-26 09:13:41
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    User findUserByUsername(String username);

    // @Param("ew") 指定参数的名称
    User findMyUserByWrapper(@Param("ew") Wrapper<User> wrapper);
}

