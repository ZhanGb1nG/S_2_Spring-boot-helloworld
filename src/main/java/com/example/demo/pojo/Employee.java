package com.example.demo.pojo;

import lombok.Data;

import java.math.BigInteger;

/**
 * @Author ZhanG_b1nG
 * @Date 2021/8/31 16:26
 * @Version 1.0
 **/
@Data
public class Employee {
    private int id;
    private String lastName;
    private String email;
    private String gender;
    private int deptId;
}
