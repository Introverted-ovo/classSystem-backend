package org.example.springboot_project.dao;


import org.apache.ibatis.annotations.Param;
import org.example.springboot_project.entity.Params;
import org.example.springboot_project.entity.Course;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CourseDao extends Mapper<Course> {


    List<Course> findBySearch(@Param("params") Params params);
}
