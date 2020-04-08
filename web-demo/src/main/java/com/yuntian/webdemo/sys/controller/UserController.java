package com.yuntian.webdemo.sys.controller;

import com.yuntian.webdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guangleilei.
 * @date Created in 17:27 2019/10/18
 * @description
 */
@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/list")
    public ModelAndView index(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("小王", 12, "男"));
        users.add(new User("小李", 13, "女"));
        users.add(new User("小张", 14, "男"));
        model.addAttribute("users", users);
        return new ModelAndView("userList");
    }
}


