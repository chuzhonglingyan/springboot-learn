package com.yuntian.webdemo.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author guangleilei.
 * @date Created in 17:06 2019/10/18
 * @description
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        return "index";
    }
}
