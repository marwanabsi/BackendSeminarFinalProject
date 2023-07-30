package com.Graduation.TeacherAssistantProject.Course.Services;

import com.Graduation.TeacherAssistantProject.Course.Models.CourseClass;
import com.Graduation.TeacherAssistantProject.Course.Repositories.CourseClassRepo;
import com.Graduation.TeacherAssistantProject.Course.Models.CourseDays;
import com.Graduation.TeacherAssistantProject.Course.Repositories.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CourseClassService {

    private final CourseClassRepo courseClassRepo;
    private final CourseRepo courseRepo;

    public ResponseEntity AddCourseClass(CourseClassRequest request) {
        var course = courseRepo.findByName(request.getCourse());
        var courseDays = new CourseDays();
        courseDays.setEndTime(request.getEndTime());
        var courseDayss = new CourseDays();
        courseDayss.setStartTime(request.getStartTime());

        var courseClass = CourseClass.builder()
                .course(course)
                .daysAndTimes(Collections.singletonList(courseDays))
                .daysAndTimes(Collections.singletonList(courseDayss))
                .build();
        courseDayss.setCourse(courseClass);

        courseClassRepo.save(courseClass);
        return ResponseEntity.ok("Done");
    }
}

