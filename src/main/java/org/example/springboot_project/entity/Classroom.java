package org.example.springboot_project.entity;

import javax.persistence.*;

@Table(name="classroom")
public class Classroom {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     @Column(name = "position")
     private String position;
     @Column(name = "size")
     private String size;

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getPosition() {
          return position;
     }

     public void setPosition(String position) {
          this.position = position;
     }

     public String getSize() {
          return size;
     }

     public void setSize(String size) {
          this.size = size;
     }
}
