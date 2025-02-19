package org.example.springboot_project.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.springboot_project.dao.CourseDao;
import org.example.springboot_project.entity.Course;
import org.example.springboot_project.entity.Params;
import org.example.springboot_project.entity.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService {

    @Resource
    private CourseDao courseDao;


    public PageInfo<Course> findBySearch(Params params) {
        //开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Course> CourseList = courseDao.findBySearch(params);
        return PageInfo.of(CourseList);
    }

    public void add(Course course) {
        courseDao.insertSelective(course);
    }
    public void update(Course course) {
        courseDao.updateByPrimaryKeySelective(course);
    }

    public void delete(Integer id) {
        courseDao.deleteByPrimaryKey(id);
    }


}
