package com.yuntian.mybatisdynamic;

import com.alibaba.fastjson.JSON;
import com.yuntian.mybatisdynamic.entity.Course;
import com.yuntian.mybatisdynamic.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Random;

@Slf4j
@SpringBootTest
class MybatisDynamicDemoApplicationTests {
    @Resource
    private CourseService courseService;


    @Test
    void contextLoads() {
        Course course = courseService.queryById(1);
        log.info(JSON.toJSONString(course));
    }


    @Test
    public void insertTest() {
        Course demo = new Course();
        demo.setName("测试" + new Random().nextInt(100));
        courseService.insert(demo);
    }

    @Test
    public void listByAllTest() {
        System.out.println(JSON.toJSONString(courseService.queryAllByLimit(0, 10)));
    }

    @Test
    public void insertAndSelectTest1() {
        Course demo = new Course();
        demo.setName("测试a" + new Random().nextInt(100));
        System.out.println(JSON.toJSONString(courseService.insertAndSelect1(demo)));
    }

    @Test
    public void insertAndSelectTest2() {
        Course demo = new Course();
        demo.setName("测试a" + new Random().nextInt(100));
        System.out.println(JSON.toJSONString(courseService.insertAndSelect2(demo)));
    }


}
