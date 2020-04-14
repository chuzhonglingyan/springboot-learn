package com.yuntian.mybatisdynamic.service.impl;

import com.yuntian.mybatisdynamic.entity.Course;
import com.yuntian.mybatisdynamic.dao.CourseDao;
import com.yuntian.mybatisdynamic.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Course)表服务实现类
 *
 * @author makejava
 * @since 2020-04-14 17:19:28
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Course queryById(Integer id) {
        return this.courseDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Course> queryAllByLimit(int offset, int limit) {
        return this.courseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course insert(Course course) {
        this.courseDao.insert(course);
        return course;
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course update(Course course) {
        this.courseDao.update(course);
        return this.queryById(course.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.courseDao.deleteById(id) > 0;
    }


    /**
     * 插入数据后马上查询记录
     * @param entity
     */
    @Override
    @Transactional
    public List<Course> insertAndSelect1(Course entity){
        insert(entity);
        return queryAllByLimit(0,10);
    }

    /**
     * 插入数据后马上查询记录
     * @param entity
     */
    @Override
    public List<Course> insertAndSelect2(Course entity){
        insert(entity);
        return queryAllByLimit(0,10);
    }


}