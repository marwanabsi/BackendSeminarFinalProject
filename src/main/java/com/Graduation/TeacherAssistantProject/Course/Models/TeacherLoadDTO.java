package com.Graduation.TeacherAssistantProject.Course.Models;

import lombok.Data;

@Data
public class TeacherLoadDTO {
    private int id;
    private String Day;
    private String startTime;
    private String endTime;
    private String courseName;
}
