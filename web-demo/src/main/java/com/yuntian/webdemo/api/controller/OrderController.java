package com.yuntian.webdemo.api.controller;

import com.yuntian.webdemo.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guangleilei.
 * @date Created in 17:27 2019/10/18
 * @description
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @PostMapping("/createOrder")
    public Result createOrder() {
        return new Result();
    }

}


