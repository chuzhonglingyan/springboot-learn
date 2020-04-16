package com.yuntian.apidemo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guangleilei.
 * @date Created in 17:27 2019/10/18
 * @description
 */
@AllArgsConstructor
@Data
public class User {


    private Long id;

    private String name;

    private Integer age;

    private String sex;


}
