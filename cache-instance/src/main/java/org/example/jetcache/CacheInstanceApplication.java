package org.example.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 * @author: lwh
 * @create: 2021/9/8 14:06
 **/
@SpringBootApplication
// 开启缓存实例注解
@EnableCreateCacheAnnotation
public class CacheInstanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheInstanceApplication.class);
    }
}
