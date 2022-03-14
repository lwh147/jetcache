package org.example.jetcache.service.impl;

/**
 * @description: TODO
 * @author: lwh
 * @create: 2021/9/15 15:54
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        try {
            System.out.println("try语句块内的");
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            System.out.println("执行了finally");
        }
        return 2;
    }
}
