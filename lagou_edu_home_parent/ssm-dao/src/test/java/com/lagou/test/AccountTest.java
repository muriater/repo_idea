package com.lagou.test;

import com.lagou.dao.AccountMapper;
import com.lagou.dao.CourseMapper;
import com.lagou.domain.Account;
import com.lagou.domain.Course;
import com.lagou.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Test
    public void t1(){
        List<Account> list = accountMapper.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
    @Test
    public void t2(){
        Course course = new Course();
        course.setCourseName("A");
        course.setCreateTime(new Date());
        course.setUpdateTime(new Date());
        courseMapper.saveCourse(course);

    }

}
