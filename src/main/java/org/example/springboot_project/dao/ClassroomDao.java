package org.example.springboot_project.dao;


import org.apache.ibatis.annotations.Param;
import org.example.springboot_project.entity.Classroom;
import org.example.springboot_project.entity.Params;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ClassroomDao extends Mapper<Classroom> {


    List<Classroom> findBySearch(@Param("params") Params params);
}
