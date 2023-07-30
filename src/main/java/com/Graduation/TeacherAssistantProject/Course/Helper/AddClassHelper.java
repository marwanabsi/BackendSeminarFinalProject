package com.Graduation.TeacherAssistantProject.Course.Helper;

import com.Graduation.TeacherAssistantProject.Course.Models.CourseClass;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherLoad;
import com.Graduation.TeacherAssistantProject.Course.Repositories.TeacherLoadReop;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data

public class AddClassHelper {

    public void addClass(TeacherAssistant teacherAssistant, CourseClass bestcourse, TeacherLoadReop teacherLoadReop) {
        if (teacherAssistant.hasTime(bestcourse)) {
            for (int i = 0; i < bestcourse.getDaysAndTimes().size(); i++) {
                TeacherLoad teacherLoad = new TeacherLoad();
                teacherLoad.setStartTime(bestcourse.getDaysAndTimes().get(i).getStartTime());
                teacherLoad.setEndTime(bestcourse.getDaysAndTimes().get(i).getEndTime());
                teacherLoad.setDay(bestcourse.getDaysAndTimes().get(i).getDay());
                teacherLoad.setCourse(bestcourse);
                teacherLoad.setTeacherAssistant(teacherAssistant);
                teacherLoadReop.save(teacherLoad);
                var k = teacherAssistant.getTeacherLoads();
                k.add(teacherLoad);
                teacherAssistant.setTeacherLoads(k);
            }
        }
    }
}
