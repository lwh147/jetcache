package org.example.jetcache.controller;

import org.example.jetcache.entity.User;
import org.example.jetcache.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 测试控制器
 * @author: lwh
 * @create: 2021/9/10 11:40
 **/
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用来测试缓存刷新功能，第一次执行该查询之后会刷新四次缓存，然后缓存失活停止刷新，如果此时再次
     * 调用该方法则会重新激活缓存刷新
     **/
    @GetMapping("get/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
