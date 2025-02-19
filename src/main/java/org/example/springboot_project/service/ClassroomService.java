package org.example.springboot_project.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.springboot_project.dao.ClassroomDao;
import org.example.springboot_project.entity.Classroom;
import org.example.springboot_project.entity.Params;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassroomService {

    @Resource
    private ClassroomDao classroomDao;


    public PageInfo<Classroom> findBySearch(Params params) {
        //开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Classroom> ClassroomList = classroomDao.findBySearch(params);
        return PageInfo.of(ClassroomList);
    }

    public void add(Classroom classroom) {
        classroomDao.insertSelective(classroom);
    }
    public void update(Classroom classroom) {
        classroomDao.updateByPrimaryKeySelective(classroom);
    }

    public void delete(Integer id) {
        classroomDao.deleteByPrimaryKey(id);
    }


}
