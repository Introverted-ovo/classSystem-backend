package org.example.springboot_project.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.springboot_project.common.JwtTokenUtils;
import org.example.springboot_project.dao.AdminDao;
import org.example.springboot_project.entity.Admin;
import org.example.springboot_project.entity.Params;
import org.example.springboot_project.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminDao adminDao;

    public PageInfo<Admin> findBySearch(Params params) {
        //开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Admin> AdminList = adminDao.findBySearch(params);
        return PageInfo.of(AdminList);
    }

    public void add(Admin admin) {
        if(admin.getName() == null || "".equals(admin.getName())){
            throw new CustomException("用户名不能为空！");
        }

        Admin user = adminDao.findByName(admin.getName());
        if(user != null){
            throw new CustomException("该用户已存在！");
        }
        if( admin.getPassword() == null ) {
            admin.setPassword("123456");
        }
        adminDao.insertSelective(admin);
    }

    public void update(Admin admin) {
        adminDao.updateByPrimaryKeySelective(admin);
    }

    public void delete(Integer id) {
        adminDao.deleteByPrimaryKey(id);
    }

    public Admin login(Admin admin) {
        //判断
        if(admin.getName() == null || "".equals(admin.getName())){
            throw new CustomException("用户名不能为空！");
        }
        if(admin.getPassword() == null || "".equals(admin.getPassword())){
            throw new CustomException("密码不能为空！");
        }
        Admin user = adminDao.findByNameAndPassword(admin.getName(),admin.getPassword());

        if(user == null){
            throw new CustomException("用户名或密码错误！");
        }
        String token = JwtTokenUtils.getToken(user.getId().toString(),user.getPassword());
        user.setToken(token);
        return user;
    }

    public Admin findById(Integer id) {
        return adminDao.selectByPrimaryKey(id);
    }

    public PageInfo<Admin> findBySearch1(Params params) {
        //开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Admin> AdminList = adminDao.findBySearch1(params);
        return PageInfo.of(AdminList);
    }

    public PageInfo<Admin> findBySearch2(Params params) {
        //开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Admin> AdminList = adminDao.findBySearch2(params);
        return PageInfo.of(AdminList);
    }
}
