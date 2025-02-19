package org.example.springboot_project.entity;

import javax.persistence.*;


@Table(name="timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "am1")
    private String am1;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "position")
    private String position;

    @Column(name = "am2")
    private String am2;

    @Column(name = "teacher1")
    private String teacher1;

    @Column(name = "position1")
    private String position1;

    @Column(name = "pm1")
    private String pm1;

    @Column(name = "teacher2")
    private String teacher2;

    @Column(name = "position2")
    private String position2;

    @Column(name = "pm2")
    private String pm2;

    @Column(name = "teacher3")
    private String teacher3;

    @Column(name = "position3")
    private String position3;

    @Column(name = "classname")
    private String classname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAm1() {
        return am1;
    }

    public void setAm1(String am1) {
        this.am1 = am1;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAm2() {
        return am2;
    }

    public void setAm2(String am2) {
        this.am2 = am2;
    }


    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1;
    }

    public String getPm1() {
        return pm1;
    }

    public void setPm1(String pm1) {
        this.pm1 = pm1;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public String getPm2() {
        return pm2;
    }

    public void setPm2(String pm2) {
        this.pm2 = pm2;
    }


    public String getPosition3() {
        return position3;
    }

    public void setPosition3(String position3) {
        this.position3 = position3;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(String teacher1) {
        this.teacher1 = teacher1;
    }

    public String getTeacher2() {
        return teacher2;
    }

    public void setTeacher2(String teacher2) {
        this.teacher2 = teacher2;
    }

    public String getTeacher3() {
        return teacher3;
    }

    public void setTeacher3(String teacher3) {
        this.teacher3 = teacher3;
    }
}
