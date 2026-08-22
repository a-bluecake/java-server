package cc.abluecake.adminserver;

import cc.abluecake.adminserver.entity.User;
import cc.abluecake.adminserver.mapper.UserMapper;
import cc.abluecake.adminserver.util.RedisUtil;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdminServerApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRedis() {
        System.out.println(("----- redis method test ------"));
        List<User> userList = userMapper.selectList(null);
        // set方法存数据，键为userList
        redisUtil.set("userList", userList);
        // get方法从键userList中取数据
        System.out.println(redisUtil.get("userList"));
    }
}
