package com.yuntian.apidemo;

import com.alibaba.fastjson.JSON;
import com.yuntian.apidemo.jwt.JwtUtil;
import com.yuntian.apidemo.model.entity.User;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@WebAppConfiguration
@Slf4j
class JwtTests {

    @Resource
    private JwtUtil jwtUtil;

    @Test
    void createToken() {
        String userId="AC100002";
        Map<String, Object> param=new HashMap<>();
        User user=new User(1L,"哈哈",20,"男");
        param.put("userInfo",JSON.toJSONString(user));
        String token=jwtUtil.createToken(userId,param);
        log.info("token:"+token);
    }

    @Test
    void getTokenClaim() {
        String token="eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySW5mbyI6IntcImFnZVwiOjIwLFwiaWRcIjoxLFwibmFtZVwiOlwi5ZOI5ZOIXCIsXCJzZXhcIjpcIueUt1wifSIsImV4cCI6MTU4NzAxMDcyNiwiaWF0IjoxNTg3MDA3MTI2fQ.M0fTyqbun-2nXFGNSsMVq1IsyuxR4UrZx_uwv5mI-s_VyCYsGPLDLWNwfPC7_SjbS2nKCN5UHGQulPXUgLSoWQ";
        Claims claims=jwtUtil.getTokenClaim(token);
        log.info("userInfo："+ claims.get("userInfo"));
        log.info("expiration："+claims.getExpiration());
    }
}
