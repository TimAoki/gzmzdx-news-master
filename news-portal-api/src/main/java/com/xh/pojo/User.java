package com.xh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 用户表(User)表实体类
 *
 * @author 徐海
 * @since 2023-06-26 09:13:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//表名映射
@TableName("tb_user")
public class User {
    /* 设置这个键自增，但是前提得数据库设定了 */
//    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //年龄
    private Integer age;
    //地址
    private String address;
    //邮箱
    private String email;
    //手机号
    //映射和数据库里的表名一致
    @TableField("phone")
    private String moblephone;

}

