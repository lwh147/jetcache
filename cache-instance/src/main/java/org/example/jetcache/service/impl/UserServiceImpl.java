package org.example.jetcache.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import lombok.extern.slf4j.Slf4j;
import org.example.jetcache.entity.User;
import org.example.jetcache.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @description: jetcache创建缓存实例用法举例，通过操作创建的 Cache 实例对象来完成对缓存的操作
 * @author: lwh
 * @create: 2021/9/8 14:53
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 通过 @CreateCache 注解创建一个缓存实例，默认使用远程缓存，缓存时间为无穷大
     **/
    @CreateCache
    private Cache<Long, User> userCache;

    /**
     * 创建一个两级（内存+远程）缓存，内存中的元素个数限制在50个
     **/
    // @CreateCache(
    //         name = "UserService.userCache.",
    //         expire = 100,
    //         cacheType = CacheType.BOTH,
    //         localLimit = 50)
    // private Cache<Long, User> userCache;
    public User getUserById(Long id) {
        // 手动查询缓存
        User user = userCache.get(id);
        if (Objects.isNull(user)) {
            // 缓存中没有数据，查数据库
            // 这里新建一个user代表去查了数据库
            User user1 = new User(id, "zhangsan", 0, new Date(), 0);
            log.info("模拟查询数据库获取到的用户：{}", user1);
            userCache.put(user1.getId(), user1);
            // 也可以单独指定缓存失效时间
            // userCache.put(user1.getId(), user1, 100, TimeUnit.SECONDS);
            return user1;
        }
        // 缓存中有数据，直接返回
        return user;
    }

    public Boolean deleteUserById(Long id) {
        // 手动操作缓存对象完成缓存的删除
        userCache.remove(id);
        // 数据库删除操作...
        log.info("模拟删除用户id：{}", id);
        return true;
    }

    public Boolean updateUser(User user) {
        // 手动完成缓存的更新操作
        userCache.put(user.getId(), user);
        // 数据库更新操作...
        log.info("模拟更新用户：{}", user);
        return true;
    }

    /**
     * 创建缓存实例对象时，开启缓存自动刷新的方法
     **/
    // @PostConstruct
    // public void init() {
    //     RefreshPolicy policy = RefreshPolicy
    //             .newPolicy(10, TimeUnit.SECONDS)
    //             .stopRefreshAfterLastAccess(50, TimeUnit.SECONDS);
    //     userCache.config().setLoader(this::loadUserFromDB);
    //     userCache.config().setRefreshPolicy(policy);
    // }
    // private User loadUserFromDB(Long id) {
    //     // 这里新建一个user代表去查了数据库
    //     return new User(id, "zhangsan", 0, new Date(), 0);
    // }
}
