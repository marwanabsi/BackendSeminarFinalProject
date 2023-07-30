package com.Graduation.TeacherAssistantProject.Course.Services;

import com.Graduation.TeacherAssistantProject.Course.Models.Course;
import com.Graduation.TeacherAssistantProject.Course.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepo courseRepository;

    @Autowired
    public CourseService(CourseRepo courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(int id, Course course) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setName(course.getName());
            existingCourse.setPriority(course.getPriority());
            existingCourse.setField(course.getField());
            existingCourse.setFieldId(course.getFieldId());
            existingCourse.setClasses(course.getClasses());
            return courseRepository.save(existingCourse);
        }
        return null;
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }


}