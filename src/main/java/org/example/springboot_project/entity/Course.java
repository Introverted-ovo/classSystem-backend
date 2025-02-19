package org.example.springboot_project.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "coursename")
    private String coursename;
    @Column(name = "coursetimes")
    private Integer coursetimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Integer getCoursetimes() {
        return coursetimes;
    }

    public void setCoursetimes(Integer coursetimes) {
        this.coursetimes = coursetimes;
    }
}
