package com.Graduation.TeacherAssistantProject.Course.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double priority;
    private String field;
    private int fieldId;
   // private Instructor instructor;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<CourseClass> classes;
    public void AddClass(CourseClass classes){
        this.classes.add(classes);
    }
}
