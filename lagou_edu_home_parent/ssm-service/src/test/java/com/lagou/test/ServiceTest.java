package com.lagou.test;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-xml.xml")
public class ServiceTest {
    @Autowired
   private CourseService courseService;
    @Test
    public void t1() throws InvocationTargetException, IllegalAccessException {
        CourseVo courseVo = new CourseVo();
        courseVo.setCourseName("D");
        courseService.saveOrUpdate(courseVo);
    }
}
