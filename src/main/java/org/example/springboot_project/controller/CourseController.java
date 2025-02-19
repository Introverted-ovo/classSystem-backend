package org.example.springboot_project.controller;


import com.github.pagehelper.PageInfo;
import org.example.springboot_project.common.Result;
import org.example.springboot_project.entity.Course;
import org.example.springboot_project.entity.Params;
import org.example.springboot_project.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @GetMapping("/search")
    public Result findBySearch(Params params)
    {
        PageInfo<Course> courseList = courseService.findBySearch(params);
        return Result.success(courseList);
    }

    @PostMapping
    public Result save(@RequestBody Course course) {
        if(course.getId() == null){
            courseService.add(course);
        } else {
            courseService.update(course);
        }
        return Result.success();
    }

    @PostMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        courseService.delete(id);
        return Result.success();
    }

}
