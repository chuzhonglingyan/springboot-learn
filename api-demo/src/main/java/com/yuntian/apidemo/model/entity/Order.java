package com.yuntian.apidemo.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author guangleilei.
 * @date Created in 13:58 2020/1/13
 * @description
 */
@Data
public class Order {

   private Long orderId;

    private Long userId;


    private BigDecimal totalMoney;


   private BigDecimal payMoney;




}
