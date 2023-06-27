import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.xh.mapper.NewsMapper;
import com.xh.mapper.UserMapper;
import com.xh.pojo.News;
import com.xh.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @Author 徐海
 * @DATE 2023/6/2614:48
 * @Description:
 * @Version 1.01
 */
@SpringBootTest(classes = com.xh.GMDNewsApplication.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {
        //select id,username,password,email,phone from tb_user
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
//        user.setId(null);
        user.setUsername("hi");
        user.setPassword("12456");
        user.setAge(20);
        user.setAddress("山西");
        user.setEmail("123f5@qq.com");
        int r = userMapper.insert(user);
        System.out.println(r);
    }

    @Test
    public void testDelete() {
        int r = userMapper.deleteById(3);
        System.out.println(r);
    }

    @Test
    public void testDeleteList() {
        List<Integer> ids = new ArrayList<>();
        ids.add(3);
        ids.add(4);
        ids.add(5);
        int r = userMapper.deleteBatchIds(ids);
        System.out.println(r);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "kiki");
        map.put("password", "1213456");
        int r = userMapper.deleteByMap(map);
        System.out.println(r);
    }

    @Test
    public void testUpdate() {
        //把id为7的用户的邮箱改为1231123@qq.com
        User user = new User();
        user.setId(2);
        user.setAddress("山东");
        user.setAge(17);
        int r = userMapper.updateById(user);
        System.out.println(r);
    }

    /*  select id,username,password,age,address,email,phone  from tb_user where age > 10 and address = '贵州'
     * */
    @Test
    public void testWrapper01() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("age", 10);
        wrapper.eq("address", "贵州");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /*
    select id,username,password,age,address,email,phone
    from tb_user where id in (1,2,3)  and age between 12 and 29 and address like '%山%'
     * */
    @Test
    public void testWrapper02() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("id", 1, 2, 3);
        wrapper.between("age", 12, 29);
        wrapper.like("address", "山");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /*  select id,username,password,age,address,email,phone
    from tb_user where id in (1,2,3) and age > 10 and order by age desc
     * */
    @Test
    public void testWrapper03() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("id", 1, 2, 3);
        wrapper.gt("age", 10);
        wrapper.orderByDesc("age");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /*  select id,username,password from tb_user 查询多列
     * */
    @Test
    public void testSelect01() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id", "username", "password");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /*  select id,username from tb_user  只查一列
     * */
    @Test
    public void testSelect02() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select(User.class, new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return "username".equals(tableFieldInfo.getColumn());

            }
        });
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /*  select id,username,password,age,email,phone from tb_user 不查某一列 这里不查地址列

     * */
    @Test
    public void testSelect03() {
        QueryWrapper<User> wrapper = new QueryWrapper<>(new User());
//        wrapper.select(User.class, new Predicate<TableFieldInfo>() {
        wrapper.select(new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return !"address".equals(tableFieldInfo.getColumn());

            }
        });
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    //lambda表达式写法
    @Test
    public void testSelect003() {
        QueryWrapper<User> wrapper = new QueryWrapper<>(new User());
        wrapper.select(tableFieldInfo -> !"address".equals(tableFieldInfo.getColumn()));
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }


    /*  update user set age = 99 where id > 1
     * */
    @Test
    public void testUpdateWrapper() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.gt("id", 1);
        wrapper.set("age", 99);
        userMapper.update(null, wrapper);

    }

    @Autowired
    private NewsMapper newsMapper;
    @Test
    public void testNewMapper() {
        System.out.println(("----- selectAll method test ------"));
        List<News> news = newsMapper.selectList(null);
        System.out.println(news);

    }

}
