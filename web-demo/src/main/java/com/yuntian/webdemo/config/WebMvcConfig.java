package com.yuntian.webdemo.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author guangleilei.
 * @date Created in 17:21 2019/10/18
 * @description https://blog.csdn.net/a_squirrel/article/details/79729690
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private CookieProperties cookieProperties;


    /**
     * 添加资源拦截器 路径映射真正的目录
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }

    @Bean
    public ServletListenerRegistrationBean<SessionListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SessionListener> slrBean = new ServletListenerRegistrationBean<SessionListener>();
        slrBean.setListener(new SessionListener());
        return slrBean;
    }

    @Bean
    CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SESSION");
        serializer.setCookieMaxAge((int) cookieProperties.getTimeout().getSeconds());
        //这样域名相同,同根下的所有web应用就可以轻松实现单点登录共享session
        serializer.setCookiePath("/");
        return serializer;
    }
}
