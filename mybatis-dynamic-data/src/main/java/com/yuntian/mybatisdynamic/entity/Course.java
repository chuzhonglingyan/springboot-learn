package com.yuntian.mybatisdynamic.entity;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2020-04-14 17:19:28
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 671923494118177730L;
    
    private Integer id;
    
    private String name;
    
    private Double lessonPeriod;
    
    private Double score;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLessonPeriod() {
        return lessonPeriod;
    }

    public void setLessonPeriod(Double lessonPeriod) {
        this.lessonPeriod = lessonPeriod;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

}