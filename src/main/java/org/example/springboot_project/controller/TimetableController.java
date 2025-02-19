package org.example.springboot_project.controller;


import com.github.pagehelper.PageInfo;
import org.example.springboot_project.common.Result;
import org.example.springboot_project.entity.Timetable;
import org.example.springboot_project.entity.Params;
import org.example.springboot_project.service.TimetableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/timetable")
public class TimetableController {

    @Resource
    private TimetableService timetableService;

    @GetMapping("/search")
    public Result findBySearch(Params params)
    {
        PageInfo<Timetable> timetableList = timetableService.findBySearch(params);
        return Result.success(timetableList);
    }

    @PostMapping
    public Result save(@RequestBody Timetable timetable) {
        if(timetable.getId() == null){
            timetableService.add(timetable);
        } else {
            timetableService.update(timetable);
        }
        return Result.success();
    }

    @PostMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        timetableService.delete(id);
        return Result.success();
    }

}
