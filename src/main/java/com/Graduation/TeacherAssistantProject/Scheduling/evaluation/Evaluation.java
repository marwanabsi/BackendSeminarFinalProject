package com.Graduation.TeacherAssistantProject.Scheduling.evaluation;

import com.Graduation.TeacherAssistantProject.Course.Models.Course;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;
import jakarta.persistence.OneToOne;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data  //makes getters and setters by default
@Builder //
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Evaluation {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "evaluation")
    private TeacherAssistant teacherAssistant;

    private int EvaluationScore;
    private boolean isInRamallah;
    private int ExperienceYears;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courseList;
    private boolean isPartTime;
    private boolean isScholarship;
    private boolean isFullTimeScholarShip;
    private boolean isPartTimeScholarShip;
    private int preferedLoad;
    private String VacationDay;
    private int preferedLabsLoad;

    private int experienceClassesNumber;

    public void evaluate() {
        int evaluation = 0;
        if (isInRamallah) {
            evaluation += 2.5;
        }
        if (courseList.size() > 2) {
            evaluation += 1;
        }
        if (courseList.size() > 4) {
            evaluation += 1.5;
        }
        if (isPartTime) {
            evaluation -= 0.5;
        }
        if (isScholarship) {
            evaluation -= 0.5;
        }
        if (preferedLoad > 40) {
            evaluation += 1;
        }
        if (isFullTimeScholarShip) {
            evaluation -= 0.3;
        }
        if (isPartTimeScholarShip) {
            evaluation -= 0.5;
        }
        if (experienceClassesNumber > 1) {
            evaluation += 1;
        }
        if (experienceClassesNumber > 6) {
            evaluation += 2;
        }

        this.EvaluationScore=evaluation;
    }





}
