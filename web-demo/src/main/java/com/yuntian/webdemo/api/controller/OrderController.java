package com.yuntian.webdemo.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author guangleilei.
 * @date Created in 17:27 2019/10/18
 * @description
 */
@RestController
@RequestMapping("user")
public class OrderController {

    @PostMapping("/createOrder")
    public ModelAndView createOrder(Model model) {
        return new ModelAndView("userList");
    }

}


