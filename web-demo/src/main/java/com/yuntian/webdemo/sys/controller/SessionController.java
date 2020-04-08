package com.yuntian.webdemo.sys.controller;

import org.springframework.session.web.http.CookieSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yuntian
 * @date 2020/3/18 0018 23:06
 * @description https://www.cnblogs.com/softidea/p/10323310.html
 */
@RestController
@RequestMapping("session")
public class SessionController {


    @RequestMapping("/getSession")
    public Map getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", session.getId());
        Map<String, String> data = new HashMap<>();
        data.put("userName", (String) session.getAttribute("userName"));
        data.put("port", request.getLocalPort()+"");
        map.put("data", data);
        return map;
    }

    @RequestMapping("/setAttribute")
    public String put(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", "张三");
        return "给:"+session.getId()+"设置数据";
    }
}
