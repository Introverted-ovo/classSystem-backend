package org.example.springboot_project.controller;


import com.github.pagehelper.PageInfo;
import org.example.springboot_project.common.Result;
import org.example.springboot_project.entity.Classroom;
import org.example.springboot_project.entity.Params;
import org.example.springboot_project.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Resource
    private ClassroomService classroomService;

    @GetMapping("/search")
    public Result findBySearch(Params params)
    {
        PageInfo<Classroom> classroomList = classroomService.findBySearch(params);
        return Result.success(classroomList);
    }

    @PostMapping
    public Result save(@RequestBody Classroom classroom) {
        if(classroom.getId() == null){
            classroomService.add(classroom);
        } else {
            classroomService.update(classroom);
        }
        return Result.success();
    }

    @PostMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        classroomService.delete(id);
        return Result.success();
    }

}
