package com.Graduation.TeacherAssistantProject.Course.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class TeacherLoad {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;
    private String Day;
    private String startTime;
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private CourseClass course;


    @ManyToOne
    @JoinColumn(name = "teacher_assistant_id")
    @JsonIgnore
    private TeacherAssistant teacherAssistant;


}
