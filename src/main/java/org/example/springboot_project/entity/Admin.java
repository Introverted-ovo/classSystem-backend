package org.example.springboot_project.entity;

import javax.persistence.*;

@Table(name="admin")
public class Admin {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     @Column(name = "name")
     private String name;
     @Column(name = "password")
     private String password;
     @Column(name = "sex")
     private String sex;
     @Column(name = "age")
     private Integer age;
     @Column(name = "phone")
     private String phone;
     @Column(name = "class0")
     private String class0;
     @Column(name = "college")
     private String college;
     @Column(name = "profession")
     private String profession;
     @Column(name = "role")
     private String role;
     @Transient
     private String token;

     public String getToken() {
          return token;
     }

     public void setToken(String token) {
          this.token = token;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getSex() {
          return sex;
     }

     public void setSex(String sex) {
          this.sex = sex;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }

     public String getPhone() {
          return phone;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public String getCollege() {
          return college;
     }

     public void setCollege(String college) {
          this.college = college;
     }

     public String getProfession() {
          return profession;
     }

     public void setProfession(String profession) {
          this.profession = profession;
     }

     public String getRole() {
          return role;
     }

     public void setRole(String role) {
          this.role = role;
     }

     public String getClass0() {
          return class0;
     }

     public void setClass0(String class0) {
          this.class0 = class0;
     }
}
