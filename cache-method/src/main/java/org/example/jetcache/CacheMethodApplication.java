package org.example.jetcache;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 * @author: lwh
 * @create: 2021/9/8 17:42
 **/
@SpringBootApplication
// 开启方法缓存注解，需要指定使用了注解的类的基础包路径
@EnableMethodCache(basePackages = "org.example.jetcache.service")
public class CacheMethodApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheMethodApplication.class);
    }
}
