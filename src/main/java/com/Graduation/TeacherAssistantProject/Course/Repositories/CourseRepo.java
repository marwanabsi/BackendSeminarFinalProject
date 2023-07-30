package com.Graduation.TeacherAssistantProject.Course.Repositories;

import com.Graduation.TeacherAssistantProject.Course.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {
    Course findByName(String Name);
}
