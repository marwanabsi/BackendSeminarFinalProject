package com.Graduation.TeacherAssistantProject.Scheduling.Schedue;

import com.Graduation.TeacherAssistantProject.Course.Models.CourseClass;
import com.Graduation.TeacherAssistantProject.Course.Repositories.*;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;
import com.Graduation.TeacherAssistantProject.Course.Repositories.*;
import com.Graduation.TeacherAssistantProject.Scheduling.Models.ClassTeacherAssistant;
import com.Graduation.TeacherAssistantProject.Scheduling.Models.GenericPriorityQueue;
import com.Graduation.TeacherAssistantProject.Scheduling.evaluation.EvaluationRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.List;
@Data
@Service
@RequiredArgsConstructor
public class TeacherAssistantScheduler {

    private final CourseRepo courseRepo;
    private final TeacherLoadReop teacherLoadReop;
    private final CourseClassRepo courseClassRepo;
    private final EvaluationRepo evaluationRepo;
    private final TeacherAssistantRepo teacherAssistantRepo;
    private final InstructorRepo instructorRepo;
    private List<CourseClass> courseClasses;
    private List<TeacherAssistant> teacherAssistants;
    private List<ClassTeacherAssistant> classAssistantList;
    public void intialize() {
        courseClasses = courseClassRepo.findAll();
        teacherAssistants = teacherAssistantRepo.findAll();
        classAssistantList = new ArrayList<ClassTeacherAssistant>();
        for (int i = 0; i < courseClasses.size(); i++) {

            for (int j = 0; j < teacherAssistants.size(); j++) {

                double weight = getEvaluation(courseClasses.get(i), teacherAssistants.get(j));

                var classTeacherEval = ClassTeacherAssistant.builder().
                        teacherAssistant(teacherAssistants.get(j)).courseClass(courseClasses.get(i)).weight(weight).build();
                classAssistantList.add(classTeacherEval);

            }
        }

        MapTaToCourses();
    }

    private int findTeacherIndex(TeacherAssistant teacherAssistant) {
        for (int i = 0; i < teacherAssistants.size(); i++) {
            if (teacherAssistants.get(i).equals(teacherAssistant)) {
                return i;
            }
        }
        return -1;
    }


    public void MapTaToCourses() {
        for (int i = 0; i < courseClasses.size(); i++) {
            var res = getBestTa(courseClasses.get(i));
            courseClasses.get(i).setTeacherAssistant(res.getTeacherAssistant());
            int teacherindex = findTeacherIndex(res.getTeacherAssistant());
            var teacher = teacherAssistants.get(teacherindex);
           teacher.setLoadedHours((teacherAssistants.get(teacherindex).getLoadedHours()) + 2);
            System.out.println(teacherAssistants.get(teacherindex).getName() + " " +  courseClasses.get(i).getCourse().getName());
            teacher.addClass(courseClasses.get(i));
            courseClassRepo.save(courseClasses.get(i));
            teacherAssistantRepo.save(teacher);
        }
    }

    private ClassTeacherAssistant getBestTa(CourseClass courseClass) {
        GenericPriorityQueue<ClassTeacherAssistant> pq = new GenericPriorityQueue<ClassTeacherAssistant>();
        boolean flag=false;
        boolean courseFlag = false;
        for(int i = 0 ; i < classAssistantList.size();i++){
            var current = classAssistantList.get(i);
            if( current.getCourseClass().equals(courseClass) && current.getTeacherAssistant().hasTime(courseClass) ){
              for(int j = 0 ; j < current.getCourseClass().getDaysAndTimes().size() ; j ++ ){

                  if(current.getCourseClass().getDaysAndTimes().get(i).equals("Thursday") && current.getTeacherAssistant().getEvaluation().isInRamallah()){
                      flag = true;
                  }


              }
                if(current.getTeacherAssistant().getEvaluation().getExperienceYears()<=1 && current.getCourseClass().getCourse().equals("Data Structure")&& current.getCourseClass().getCourse().equals("Algorthim")){
                    courseFlag = true;
                }


                if (!flag || !courseFlag) {
                    pq.enqueue(current, current.weight);
                    flag=false;
                    courseFlag=false;
                }
            }


        }
        return pq.dequeue();
    }

    public double getEvaluation(CourseClass courseClass, TeacherAssistant teacherAssistant){
        double evaluation=0;
        evaluation=Math.random()*10;
        var eval = teacherAssistant.getEvaluation();
        if(teacherAssistant.getEvaluation()!=null){
            eval.evaluate();
        evaluation+= eval.getEvaluationScore();
        evaluationRepo.save(eval);
        for(int i = 0 ; i< eval.getCourseList().size();i++){
            if(eval.getCourseList().get(i).equals(courseClass.getCourse())){
                evaluation+=5;
            }
        }

      }
        return evaluation;
    }


}
