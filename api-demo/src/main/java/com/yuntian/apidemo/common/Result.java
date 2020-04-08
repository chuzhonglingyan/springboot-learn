package com.yuntian.apidemo.common;

import lombok.Data;

/**
 * @author guangleilei.
 * @date Created in 14:03 2020/1/13
 * @description
 */
@Data
public class Result<T> {

    private T data;

    private Integer code;

    private String msg;
}
