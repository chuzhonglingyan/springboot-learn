package com.yuntian.webdemo.config;

import java.time.LocalDateTime;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuntian
 * @date 2020/3/20 0020 16:35
 * @description
 */
@Slf4j
@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        log.info("sessionCreated:"+session.getId()+".时间："+ LocalDateTime.now());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        log.info("sessionDestroyed:"+session.getId()+".时间："+ LocalDateTime.now());
    }
}

