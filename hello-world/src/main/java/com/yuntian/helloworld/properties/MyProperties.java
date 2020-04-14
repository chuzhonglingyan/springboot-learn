package com.yuntian.helloworld.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author guangleilei.
 * @date Created in 11:23 2019/8/13
 * @description 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 * prefix = "xxx"：配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能；
 * @ConfigurationProperties(prefix = "xxx")默认从全局配置文件中获取值；
 */
@Component
@ConfigurationProperties("my")
public class MyProperties {

    private String url;

    private String secret;

    private Integer number;

    private Long bignumber;

    private String uuid;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
