package org.example.springboot_project.controller;


import com.github.pagehelper.PageInfo;
import org.example.springboot_project.common.Result;
import org.example.springboot_project.entity.Admin;
import org.example.springboot_project.entity.Params;
import org.example.springboot_project.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin) {
        Admin loginUser = adminService.login(admin);
        return Result.success(loginUser);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Admin admin) {
        adminService.add(admin);
        return Result.success();
    }


    @PostMapping
    public Result save(@RequestBody Admin admin) {
        if(admin.getId() == null){
            adminService.add(admin);
        } else {
            adminService.update(admin);
        }
        return Result.success();
    }


    @GetMapping("/search")
    public Result findBySearch(Params params)
    {
        PageInfo<Admin> adminList = adminService.findBySearch(params);
        return Result.success(adminList);
    }

    @GetMapping("/search1")
    public Result findBySearch1(Params params)
    {
        PageInfo<Admin> adminList = adminService.findBySearch1(params);
        return Result.success(adminList);
    }

    @GetMapping("/search2")
    public Result findBySearch2(Params params)
    {
        PageInfo<Admin> adminList = adminService.findBySearch2(params);
        return Result.success(adminList);
    }

    @PostMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        adminService.delete(id);
        return Result.success();
    }
}
