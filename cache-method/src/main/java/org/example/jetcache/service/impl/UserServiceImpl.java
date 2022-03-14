package org.example.jetcache.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import lombok.extern.slf4j.Slf4j;
import org.example.jetcache.entity.User;
import org.example.jetcache.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description: jetcache创建方法缓存用法举例，与 SpringCache类似
 * @author: lwh
 * @create: 2021/9/8 14:53
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 使用Cached注解创建方法缓存
     * 使用CacheRefresh注解开启缓存刷新功能
     **/
    @Cached(name = "UserService.userCache.",
            key = "#id",
            expire = 100,
            cacheType = CacheType.BOTH,
            localLimit = 50)
    // @CacheRefresh(
    //         refresh = 10,
    //         stopRefreshAfterLastAccess = 50)
    public User getUserById(Long id) {
        User user = new User(id, "zhangsan", 0, new Date(), 0);
        log.info("模拟查询数据库获取到的用户：{}", user);
        return user;
    }

    @CacheInvalidate(
            name = "UserService.userCache.",
            key = "#id")
    public Boolean deleteUserById(Long id) {
        // 数据库操作...
        log.info("模拟删除用户id：{}", id);
        return true;
    }

    @CacheUpdate(
            name = "UserService.userCache.",
            key = "#user.id",
            value = "#user")
    public Boolean updateUser(User user) {
        // 数据库操作...
        log.info("模拟更新用户：{}", user);
        return true;
    }
}
