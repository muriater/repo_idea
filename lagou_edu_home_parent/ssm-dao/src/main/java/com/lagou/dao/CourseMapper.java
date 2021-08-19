package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.Teacher;

import java.util.List;

public interface CourseMapper {
    List<Course> findCourseByCondition(CourseVo courseVo);


    /*新增课程信息*/
    void saveCourse(Course course);

    /*新增讲师信息*/
    void save(Teacher teacher);

    /*回显课程信息和讲师信息*/
    CourseVo getCourseAndTeacher(Integer id);
    /*更新课程信息*/
    void updateCourse(Course course);
    /*更新讲师信息*/
    void updateTeacher(Teacher teacher);
    /*test*/
    void testCourse();
    void test1();
    void test2();
    void test3();
    void test4();
    void test5();
    void test6();
}
