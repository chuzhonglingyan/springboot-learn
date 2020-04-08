package com.yuntian.apidemo.entity;

import lombok.Data;

/**
 * @author guangleilei.
 * @date Created in 17:27 2019/10/18
 * @description
 */
@Data
public class User {


    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private Long id;

    private String name;

    private Integer age;

    private String sex;


}
