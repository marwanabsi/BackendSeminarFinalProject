package com.Graduation.TeacherAssistantProject.Course.Repositories;

import com.Graduation.TeacherAssistantProject.Course.Models.TeacherLoad;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface TeacherLoadReop extends JpaRepository<TeacherLoad, Integer> {
    default List<TeacherLoad> getteacherload(TeacherAssistant teacherAssistant) {
        List<TeacherLoad> k = findAll();
        List<TeacherLoad> answer = new ArrayList<>();
        for (int i = 0; i < k.size(); i++) {
            TeacherAssistant ta = k.get(i).getTeacherAssistant();
            if (Objects.equals(ta, teacherAssistant)) {
                answer.add(k.get(i));
            }
        }
        return answer;
    }
}


