package org.example.jetcache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 用户实体类
 * @author: lwh
 * @create: 2021/9/8 14:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    public static final String TABLE_NAME = "user";
    private Long id;
    private String name;
    private Integer sex;
    private Date birthday;
    private Integer age;
}
