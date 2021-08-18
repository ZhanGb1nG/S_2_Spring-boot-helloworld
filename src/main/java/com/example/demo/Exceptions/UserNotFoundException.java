package com.example.demo.Exceptions;

/**
 * 用户不存在异常
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/18 11:23
 * @Version 1.0
 **/
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("用户不存在");
    }
}
