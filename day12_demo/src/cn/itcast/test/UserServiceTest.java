package cn.itcast.test;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: badbad
 * @Date: 2019/9/3 20:51
 * @Version 1.0
 */
public class UserServiceTest {
    private UserService userService = new UserService();

    @Test
    public void login() {
        User user = userService.login("leijun", "123");
        System.out.println("user = " + user);
    }
}
