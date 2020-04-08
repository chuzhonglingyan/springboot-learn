package com.yuntian.apidemo.controller;

import com.yuntian.apidemo.common.Result;
import com.yuntian.apidemo.model.dto.OrderDTO;
import com.yuntian.apidemo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guangleilei.
 * @date Created in 17:27 2019/10/18
 * @description
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/createOrder")
    public Result createOrder(@RequestBody  OrderDTO orderDTO) {
        Result<Long> result=new Result<>();
        Long orderId= orderService.createOrder(orderDTO);
        if (orderId!=null){
            result.setData(orderId);
            result.setCode(99);
            result.setMsg("成功");
        }else {
            result.setCode(99);
            result.setMsg("失败");
        }
        return result;
    }

}


