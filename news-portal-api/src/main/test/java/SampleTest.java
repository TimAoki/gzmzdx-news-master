import com.xh.pojo.User;
import org.junit.jupiter.api.Test;

/**
 * @Author 徐海
 * @DATE 2023/6/2614:48
 * @Description:
 * @Version 1.01
 */
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
