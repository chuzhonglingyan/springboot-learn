package com.yuntian.apidemo.interceptor;

import com.yuntian.apidemo.jwt.JwtProperties;
import com.yuntian.apidemo.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guangleilei
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private JwtProperties jwtProperties;
    @Resource
    private JwtUtil jwtUtil;


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // Token 验证
        String token = request.getHeader(jwtProperties.getHeader());
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(jwtProperties.getHeader());
        }
        if (StringUtils.isEmpty(token)) {
            throw new Exception(jwtProperties.getHeader() + "不能为空");
        }
        Claims claims = jwtUtil.getTokenClaim(token);
        if (claims == null || jwtUtil.isTokenExpired(claims.getExpiration())) {
            throw new Exception(jwtProperties.getHeader() + "失效，请重新登录");
        }
        return true;
    }


}
