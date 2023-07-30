package com.Graduation.TeacherAssistantProject.Course.Repositories;

import com.Graduation.TeacherAssistantProject.Course.Models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
}
