package com.Graduation.TeacherAssistantProject.Course.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data  //makes getters and setters by default
@Builder //
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Instructor {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int ssid;
    private String email;
    private boolean isActive = true;

    public Instructor(String name,int ssid,String email,boolean isActive){

    }

   // @OneToMany(mappedBy="Instructor")
    //private Set<CourseClass> courseClasses;
   // @OneToMany(targetEntity = Course.class,cascade = CascadeType.ALL)
   // @JoinColumn(name="ic_fk",referencedColumnName = "id" ) //join Table instructor/course foriegn key by ID
  //  private List<Course> Courses;
   @OneToMany(
           mappedBy = "instructor",
           cascade = CascadeType.ALL,
           orphanRemoval = true
   )
   private List<CourseClass> classes;

    public boolean addClass(CourseClass newClass){
       classes.add(newClass);
       return true;

    }



}
