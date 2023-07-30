package com.Graduation.TeacherAssistantProject.Course.Controller;

import com.Graduation.TeacherAssistantProject.Course.Services.CourseClassRequest;
import com.Graduation.TeacherAssistantProject.Course.Services.CourseClassService;
import com.Graduation.TeacherAssistantProject.Course.Services.TeacherAssistantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courseclass")
@RequiredArgsConstructor
public class CourseClassController {
    private final CourseClassService service;
    @PostMapping("/addClass")
    public ResponseEntity<TeacherAssistantService> RegisterCourseClass(
            @RequestBody CourseClassRequest request

    ){
        return service.AddCourseClass(request);
    }


}
