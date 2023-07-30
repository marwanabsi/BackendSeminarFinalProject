package com.Graduation.TeacherAssistantProject.Course.Repositories;

import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherAssistantRepo extends JpaRepository<TeacherAssistant,Integer> {

}
