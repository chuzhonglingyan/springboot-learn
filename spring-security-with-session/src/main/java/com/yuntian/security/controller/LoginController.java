package com.yuntian.security.controller;

import com.yuntian.security.common.BaseController;
import com.yuntian.security.common.Result;
import com.yuntian.security.model.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @date 2020-04-16 23:42
 * @description
 */
@RestController("user")
public class LoginController extends BaseController {

    @Resource
    private AuthenticationManager myAuthenticationManager;

    @RequestMapping(value = "/userLogin")
    public Result login(UserDto userDto) {
        //验证登录成功
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword());
        Authentication authenticate = myAuthenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        return new Result();
    }

    @RequestMapping(value = "/register")
    public Result register(UserDto userDto) {

        return new Result();
    }
}
