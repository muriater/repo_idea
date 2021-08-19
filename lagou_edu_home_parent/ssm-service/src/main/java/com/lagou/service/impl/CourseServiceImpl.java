package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findCourseByCondition(CourseVo courseVo) {
        return courseMapper.findCourseByCondition(courseVo);
    }

    @Override
    public void saveOrUpdate(CourseVo courseVo)  {
        try {
            Course course = new Course();
            //BeanUtils.copyProperties(course,courseVo);
            BeanUtils.copyProperties(course,courseVo);
            //补全相关信息
            Date date = new Date();
            course.setCreateTime(date);
            course.setUpdateTime(date);
            //保存课程
            courseMapper.saveCourse(course);
            // 新增讲师相关
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacher,courseVo);
            teacher.setCourseId(course.getId());
            teacher.setCreateTime(date);
            teacher.setUpdateTime(date);
            teacher.setIsDel(0);
            courseMapper.save(teacher);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CourseVo getCourseAndTeacher(Integer id) {
        return courseMapper.getCourseAndTeacher(id);
    }


}
