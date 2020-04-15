package com.yuntian.mybatisdynamic.controller;

import com.yuntian.mybatisdynamic.entity.TestUser;
import com.yuntian.mybatisdynamic.service.TestUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TestUser)表控制层
 *
 * @author makejava
 * @since 2020-04-15 22:35:16
 */
@RestController
@RequestMapping("testUser")
public class TestUserController {
    /**
     * 服务对象
     */
    @Resource
    private TestUserService testUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestUser selectOne(Long id) {
        return this.testUserService.queryById(id);
    }

}