package com.Graduation.TeacherAssistantProject.Scheduling.evaluation;

import com.Graduation.TeacherAssistantProject.Course.Models.CourseClass;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;

import java.util.Optional;

public class CourseTeacherEvaluation {
boolean cutsVacation;
    double evaluation=0;
    public double getEvaluation(Optional<CourseClass> courseClass, TeacherAssistant teacherAssistant){
        evaluation=Math.random()*10;

        /*
        for(int i = 0;i < teacherAssistant.getClasses().size();i++){
           if( courseClass.getCourse().getId()==teacherAssistant.getEvaluation().getCourseList().get(i).getId()){
               evaluation+=3;
           }
          if(teacherAssistant.getEvaluation().getVacationDay().equals(courseClass.getDay1())&&teacherAssistant.getEvaluation().getVacationDay().equals(courseClass.getDay2())&&teacherAssistant.getEvaluation().getVacationDay().equals(courseClass.getDay3())){
              evaluation-=3;
              cutsVacation=true;
          }
          else{
              evaluation+=3;
          }
          if(teacherAssistant.getEvaluation().getExperienceYears()>2&&courseClass.getCourse().getPriority()>7){
              evaluation=+4;
          }

        }


         */
        return evaluation;
    }
}
