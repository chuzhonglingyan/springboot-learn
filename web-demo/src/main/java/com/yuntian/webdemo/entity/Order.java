package com.yuntian.webdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author guangleilei.
 * @date Created in 13:58 2020/1/13
 * @description
 */
@Data
public class Order {

    private List<GoodSKU> goodSKUList;

    private Long userId;

}
