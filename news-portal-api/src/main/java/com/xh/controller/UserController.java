package com.xh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.pojo.User;
import com.xh.service.UserService;
import com.xh.utils.JwtUtils;
import com.xh.utils.Result;
import com.xh.utils.TokenResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author 徐海
 * @since 2023-06-26 21:24:29
 */
@RestController
@RequestMapping("user")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    @PostMapping("login")
    public TokenResult login(@RequestBody User user) {

        String username = user.getUsername();
        String userByUsername = userService.findUserByUsername(username).getUsername();
        String password = user.getPassword();
        String password1 = userService.findUserByUsername(user.getUsername()).getPassword();

        if (userByUsername.equals(username)) {
            if (password.equals(password1)) {
                String token = JwtUtils.generateToken(user.getUsername());
                return TokenResult.ok().data("name", username).data("token", token);

            }
            return TokenResult.error();
        }

        return TokenResult.error();

    }

    @GetMapping("info")
    public TokenResult info(String token) {
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        String username1 = userService.findUserByUsername(username).getUsername();
        String url = "https://img1.baidu.com/it/u=4049022245,514596079&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500";
        return TokenResult.ok().data("name", username1).data("avatar", url);

    }

    @PostMapping("logout")
    public TokenResult logout() {
        return TokenResult.ok();
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping("selectAll")
    public Result selectAll(Page<User> page, User user) {
        return  Result.buildResult(Result.ok(),this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody User user) {
        return success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody User user) {
        return success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }
}

