package org.example.springboot_project.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.springboot_project.entity.Admin;
import org.example.springboot_project.entity.Params;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdminDao extends Mapper<Admin> {


    List<Admin> findBySearch(@Param("params") Params params);

    @Select("select * from admin where name = #{name} limit 1")
    Admin findByName(@Param("name") String name);

    @Select("select * from admin where name = #{name} and password = #{password} limit 1")
    Admin findByNameAndPassword(@Param("name")String name, @Param("password") String password);

    List<Admin> findBySearch1(@Param("params") Params params);

    List<Admin> findBySearch2(@Param("params") Params params);
}
