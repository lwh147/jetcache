package org.example.jetcache.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.jetcache.entity.User;
import org.example.jetcache.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void getUserById() {
        log.info("获取id为1的User信息：{}", JSON.toJSONString(userService.getUserById(1L)));
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(1L);
    }

    @Test
    public void updateUser() {
        User user = new User(1L, "lisi", 1, new Date(), 10);
        log.info("更新id为1的User信息：{}", JSON.toJSONString(user));
        Assert.assertTrue(userService.updateUser(user));
        log.info("获取id为1的User信息：{}", JSON.toJSONString(userService.getUserById(1L)));
    }
}