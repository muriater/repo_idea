package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.Teacher;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {
    List<Course> findCourseByCondition(CourseVo courseVo);

    void saveOrUpdate(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;
    /**
     * 课程信息及讲师信息回显
     */
    CourseVo getCourseAndTeacher(Integer id);
}
