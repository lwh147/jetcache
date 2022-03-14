package org.example.jetcache.service;

import org.example.jetcache.entity.User;

/**
 * @description: UserService
 * @author: lwh
 * @create: 2021/9/8 14:53
 **/
public interface UserService {
    User getUserById(Long id);

    Boolean deleteUserById(Long id);

    Boolean updateUser(User user);
}
