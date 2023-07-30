package com.Graduation.TeacherAssistantProject.Scheduling.Models;

import com.Graduation.TeacherAssistantProject.Course.Models.CourseClass;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassTeacherAssistant {

    private int id;
    private CourseClass courseClass;
    private TeacherAssistant teacherAssistant;
    public double weight;
}
