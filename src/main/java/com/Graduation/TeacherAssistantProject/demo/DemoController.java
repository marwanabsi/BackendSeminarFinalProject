package com.Graduation.TeacherAssistantProject.demo;

import com.Graduation.TeacherAssistantProject.Course.Models.*;
import com.Graduation.TeacherAssistantProject.Course.Repositories.CourseClassRepo;
import com.Graduation.TeacherAssistantProject.Course.Repositories.TeacherAssistantRepo;
import com.Graduation.TeacherAssistantProject.Course.Models.*;
import com.Graduation.TeacherAssistantProject.Course.Repositories.CourseRepo;
import com.Graduation.TeacherAssistantProject.Course.Repositories.InstructorRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/api/v1/demo-controller")
public class DemoController {


    private final CourseClassRepo classRepo;
    private final CourseRepo courseRepo;
    private final InstructorRepo instructorRepo;
    private final TeacherAssistantRepo teacherAssistantRepo;

    public DemoController(CourseClassRepo repository, CourseRepo courseRepo, InstructorRepo instructorRepo, TeacherAssistantRepo teacherAssistantRepo) {
        this.classRepo = repository;
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
        this.teacherAssistantRepo = teacherAssistantRepo;
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){

        String name ="null";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            name = currentUserName;
        }

        Instructor instructor = new Instructor();
        instructor.setEmail("abed@gmail.com");
        instructor.setActive(true);
        instructor.setSsid(112);
        instructorRepo.save(instructor);
        //


        Course course = new Course();
        course.setName("Data Structure");
        course.setPriority(4);
        course.setField("Science");
        course.setFieldId(1);


        Course course2 = new Course();
        course2.setName("Lenux");
        course2.setPriority(1);
        course2.setField("Science");
        course2.setFieldId(2);


        Course course3 = new Course();
        course3.setName("AI");
        course3.setPriority(4);
        course3.setField("Science");
        course3.setFieldId(3);

        Course course4 = new Course();
        course4.setName("DataBase");
        course4.setPriority(4);
        course4.setField("Science");
        course4.setFieldId(4);

        Course course5 = new Course();
        course5.setName("Algorithm");
        course5.setPriority(5);
        course5.setField("Science");
        course5.setFieldId(4);

        Course course6 = new Course();
        course6.setName("Java");
        course6.setPriority(1);
        course6.setField("Science");
        course6.setFieldId(1);

        Course course7 = new Course();
        course7.setName("Compiler");
        course7.setPriority(4);
        course7.setField("Science");
        course7.setFieldId(1);

        Course course8 = new Course();
        course8.setName("software");
        course8.setPriority(4);
        course8.setField("Science");
        course8.setFieldId(1);

        Course course9 = new Course();
        course9.setName("C");
        course9.setPriority(1);
        course9.setField("Science");
        course9.setFieldId(2);

        Course course11 = new Course();
        course11.setName("Game Engin");
        course11.setPriority(2);
        course11.setField("Science");
        course11.setFieldId(3);

        Course course12 = new Course();
        course12.setName("Mobile");
        course12.setPriority(2);
        course12.setField("Science");
        course12.setFieldId(4);

        Course course14 = new Course();
        course14.setName("WEB");
        course14.setPriority(2);
        course14.setField("Science");
        course14.setFieldId(4);

        Course course15 = new Course();
        course15.setName("OS");
        course15.setPriority(4);
        course15.setField("Science");
        course15.setFieldId(1);


        courseRepo.save(course);
        courseRepo.save(course2);
        courseRepo.save(course3);
        courseRepo.save(course4);
        courseRepo.save(course5);
        courseRepo.save(course6);
        courseRepo.save(course7);
        courseRepo.save(course8);
        courseRepo.save(course9);
        courseRepo.save(course11);
        courseRepo.save(course12);
        courseRepo.save(course14);
        courseRepo.save(course15);







        TeacherAssistant teacherAssistant = new TeacherAssistant();

        teacherAssistant.setAvailable(true);
        teacherAssistant.setEvauluationScore(10);
        teacherAssistant.setLoadHours(5);

        CourseClass courseClass = new CourseClass();
        courseClass.setCourse(course);
        courseClass.setInstructor(instructor);

        // ############# Course 2
        CourseClass courseClass2 = new CourseClass();
        courseClass2.setCourse(course2);
        courseClass2.setInstructor(instructor);

        List<CourseDays> list2 = new ArrayList<CourseDays>();

        CourseDays courseDays = new CourseDays();
        courseDays.setStartTime("8");
        courseDays.setEndTime("11");
        courseDays.setDay("Monday");
        list2.add(courseDays);

        courseClass2.setDaysAndTimes(list2);
        classRepo.save(courseClass2);

        List<CourseDays> list = new ArrayList<CourseDays>();

        CourseDays courseDays2 = new CourseDays();
        courseDays2.setStartTime("8");
        courseDays2.setEndTime("11");
        courseDays2.setDay("Monday");
        list.add(courseDays2);

        courseClass.setDaysAndTimes(list);
        classRepo.save(courseClass);


        List<TeacherLoad> list5 = new ArrayList<TeacherLoad>();

        TeacherLoad teacherLoad = new TeacherLoad();
        teacherLoad.setStartTime("8");
        teacherLoad.setEndTime("11");
        teacherLoad.setDay("Wednesday");
        teacherLoad.setTeacherAssistant(teacherAssistant);
        teacherLoad.setCourse(courseClass);
        list5.add(teacherLoad);

        TeacherLoad teacherLoad2 = new TeacherLoad();
        teacherLoad2.setStartTime("11");
        teacherLoad2.setEndTime("14");
        teacherLoad2.setDay("Monday");
        teacherLoad2.setTeacherAssistant(teacherAssistant);
        teacherLoad2.setCourse(courseClass);
        list5.add(teacherLoad2);

        TeacherLoad teacherLoad3 = new TeacherLoad();
        teacherLoad3.setStartTime("11");
        teacherLoad3.setEndTime("14");
        teacherLoad3.setDay("Sunday");
        teacherLoad3.setTeacherAssistant(teacherAssistant);
        teacherLoad3.setCourse(courseClass2);

        list5.add(teacherLoad3);
        teacherAssistant.setTeacherLoads(list5);

        TeacherAssistant teacherAssistant1 = new TeacherAssistant();
        teacherAssistant1.addClass(courseClass2);
        teacherAssistant1.addClass(courseClass);
        teacherAssistantRepo.save(teacherAssistant);
        return ResponseEntity.ok( "hello " + name +" " ) ;
    }
}
