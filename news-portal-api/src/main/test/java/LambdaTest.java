import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.mapper.CommentMapper;
import com.xh.mapper.UserMapper;
import com.xh.pojo.Comment;
import com.xh.pojo.User;
import com.xh.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author 徐海
 * @DATE 2023/6/26 17:10
 * @Description:
 * @Version 1.01
 */
@SpringBootTest(classes = com.xh.GMDNewsApplication.class)
public class LambdaTest {
    @Autowired
    private UserMapper userMapper;


    /* select id,username,password,age,address,email,phone
    from tb_user where age > 18 and address = '贵州'
    * */
    @Test
    public void testLambdaWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 18);
        wrapper.eq("address", "贵州");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    //Lambda条件构造器写法
    @Test
    public void testLambdaWrapper2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(User::getAge, 18);
        wrapper.eq(User::getAddress, "贵州");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    @Test
    public void testMyMethod() {
        User user = userMapper.findUserByUsername("admin");
        System.out.println(user);

    }

    //自定义wrapper
    @Test
    public void testMyMethod2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        wrapper.eq("address", "贵州");
        User user = userMapper.findMyUserByWrapper(wrapper);
        System.out.println(user);
    }

    @Test
    public void testPage() {
        IPage<User> page = new Page<>();
        //设置每页条数
        page.setSize(2);
        //设置查询第几页
        page.setCurrent(1);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());//获取当前页的数据
        System.out.println(page.getTotal());//获取总记录数
        System.out.println(page.getCurrent());//当前页码
    }

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void testCommentPages() {
        Page<Comment> page = new Page<>();
        //设置每页条数
        page.setSize(1);
        //设置查询第几页
        page.setCurrent(1);
        commentMapper.findAllComments(page);
        System.out.println(page);

    }

    @Autowired
    private UserService userService;

    @Test
    public void testService() {
        List<User> list = userService.list();
        Page<User> page = new Page<>();
        page.setSize(3);
        page.setCurrent(1);
        userService.page(page);
        System.out.println(page);
    }


}
