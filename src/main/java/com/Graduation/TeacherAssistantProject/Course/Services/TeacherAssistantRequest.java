package com.Graduation.TeacherAssistantProject.Course.Services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherAssistantRequest {
    private boolean isAvailable;
    private boolean isFulltime;
    private List<String> courseList;
    private String name;
    private String VacationDay;
    private boolean isInRamallah;
    private boolean isPartTime;
    private boolean isScholarship;
    private boolean isFullTimeScholarShip;
    private boolean isPartTimeScholarShip;
    private int ExperienceYears;
    private int preferedLoad;
    private int experienceClassesNumber;
}
