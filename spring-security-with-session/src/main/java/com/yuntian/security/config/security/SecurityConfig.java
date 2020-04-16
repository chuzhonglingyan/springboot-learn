package com.yuntian.security.config.security;

import com.yuntian.security.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        http.authorizeRequests()
                .antMatchers("/favicon.ico", "/static/**", "/login","/userLogin")
                .permitAll()
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("你的登录页面.html").loginProcessingUrl("/login")
                .successHandler((httpServletRequest, response, authentication) -> {
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    PrintWriter out=response.getWriter();
                    out.write("输出登录成功json");
                    out.flush();
                    out.close();
                }).failureHandler((httpServletRequest, response, e) -> {
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    PrintWriter out=response.getWriter();
                    out.write("输出登录失败json");
                    out.flush();
                    out.close();
                });
        //开启记住我功能
        http.rememberMe().rememberMeParameter("rememberMe");
    }

    /**
     * 自定义认证数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailServiceImpl userDetailService() {
        return new UserDetailServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}