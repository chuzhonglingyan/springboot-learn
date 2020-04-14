package com.yuntian.mybatisdemo.entity;

import java.io.Serializable;

/**
 * (TestUser)实体类
 *
 * @author makejava
 * @since 2020-04-14 16:17:15
 */
public class TestUser implements Serializable {
    private static final long serialVersionUID = -71918095948884390L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 账号
    */
    private String account;
    /**
    * 密码
    */
    private String passWord;
    /**
    * 姓名
    */
    private String name;
    /**
    * 年龄
    */
    private Object age;
    /**
    * 0-男，1-女，默认为0
    */
    private Object sex;
    /**
    * 邮件
    */
    private String email;
    /**
    * 创建人
    */
    private Long createId;
    /**
    * 创建时间
    */
    private Object createTime;
    /**
    * 更新人
    */
    private Long updateId;
    /**
    * 更新时间
    */
    private Object updateTime;
    /**
    * 是否删除，0-未删除，1-删除，默认为0
    */
    private Object isDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = age;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Object isDelete) {
        this.isDelete = isDelete;
    }

}