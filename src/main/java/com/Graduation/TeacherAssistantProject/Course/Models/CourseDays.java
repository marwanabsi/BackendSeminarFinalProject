package com.Graduation.TeacherAssistantProject.Course.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CourseDays {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;
    private String Day;
    private String startTime;
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseClass course;

}
