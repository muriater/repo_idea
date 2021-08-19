package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/findCourseByConditioin")
    /*@RequestBody把前台传来的json串转成对应实体类对象*/
    public ResponseResult findByConditon(@RequestBody CourseVo courseVo){

        List<Course> list = courseService.findCourseByCondition(courseVo);
        return new ResponseResult(true,200,"响应成功",list);
    }
    /*http://localhost:8080/ssm-web/course/courseUpload*/
    @RequestMapping("/courseUpload")
    public ResponseResult PhotoUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if(file==null){
            throw new RuntimeException();
        }
        String realPath = request.getServletContext().getRealPath("/");
        //路径
        String filePath = realPath.substring(0, realPath.indexOf("ssm"));
        //名称
        String originalFilename = file.getOriginalFilename();
        //新文件名
        String fileName=System.currentTimeMillis()+originalFilename.substring(originalFilename.indexOf("."));
        System.out.println("XXX"+originalFilename.substring(originalFilename.indexOf(".")));
        //System.out.println("NewFileName"+fileName);
        // 文件上传
        String uploadPath=filePath+"upload\\";
        File f1 = new File(uploadPath,fileName);
        //判断是否存在
       if(!f1.getParentFile().exists()){
           f1.getParentFile().mkdirs();
           System.out.println("创建目录"+f1);
       }
       file.transferTo(f1);
       // 将文件名和文件路径返回
        HashMap<Object, Object> map = new HashMap<>();
        /*"http://localhost:8080/upload/1597112871741.JPG"*/
        map.put("filePath","http://localhost:8080/upload/"+fileName);
        map.put("fileName",fileName);
        return new ResponseResult(true,200,"响应成功",map);
    }
    /*http://localhost:8080/ssm/course/saveOrUpdateCourse */
    /**
     * 新增课程及讲师信息
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourseOrTeachear(@RequestBody CourseVo courseVo){
        try {
            courseService.saveOrUpdate(courseVo);
            return new ResponseResult(true,200,"相应成功",null);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*http://localhost:8080/ssm/course/findCourseById?id=16*/
    @RequestMapping("/findCourseById")
    public ResponseResult getCourseWithTeacher(@RequestParam Integer id){
        CourseVo courseAndTeacher = courseService.getCourseAndTeacher(id);
        if(courseAndTeacher!=null){
            return new ResponseResult(true,200,"相应成功",courseAndTeacher);
        }
        return null;
    }


}
