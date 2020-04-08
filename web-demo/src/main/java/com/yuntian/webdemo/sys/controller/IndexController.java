package com.yuntian.webdemo.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author guangleilei.
 * @date Created in 17:19 2019/10/18
 * @description
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("home")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("index");
        view.addObject("title", "管理系统");
        view.addObject("content", "欢迎你的到来");
        view.addObject("localServer", "本地服务器：" + getLocalUrl(request));
        view.addObject("curUrl", "当前url：" + getCurUrl(request));
        return view;
    }


    public String getCurUrl(HttpServletRequest request) {
        return request.getScheme() + request.getLocalAddr() + ":" + request.getServerPort();
    }


    /**
     * 应用服务器的端口
     *
     * @param request
     * @return
     */
    public String getLocalUrl(HttpServletRequest request) {
        return request.getScheme() + request.getLocalAddr() + ":" + request.getLocalPort();
    }

}