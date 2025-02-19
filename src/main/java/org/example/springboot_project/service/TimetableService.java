package org.example.springboot_project.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.springboot_project.dao.TimetableDao;
import org.example.springboot_project.entity.Timetable;
import org.example.springboot_project.entity.Params;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TimetableService {

    @Resource
    private TimetableDao timetableDao;


    public PageInfo<Timetable> findBySearch(Params params) {
        //开启分页查询
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<Timetable> TimetableList = timetableDao.findBySearch(params);
        return PageInfo.of(TimetableList);
    }

    public void add(Timetable timetable) {
        timetableDao.insertSelective(timetable);
    }
    public void update(Timetable timetable) {
        timetableDao.updateByPrimaryKeySelective(timetable);
    }

    public void delete(Integer id) {
        timetableDao.deleteByPrimaryKey(id);
    }


}
