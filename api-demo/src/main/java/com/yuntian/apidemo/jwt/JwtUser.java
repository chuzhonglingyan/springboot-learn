package com.yuntian.apidemo.jwt;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class JwtUser {

    @Resource
    private JwtUtil jwtUtil;

    public void  saveUserInfo(){

    }


    public void  getUserInfo(String token){

    }
}
