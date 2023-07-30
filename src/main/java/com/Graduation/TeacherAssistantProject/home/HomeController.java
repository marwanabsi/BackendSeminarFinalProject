package com.Graduation.TeacherAssistantProject.home;


import com.Graduation.TeacherAssistantProject.Scheduling.Schedue.TeacherAssistantScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HomeController {

    private final TeacherAssistantScheduler teacherAssistantScheduler;

    @GetMapping("/schedule")
    public ResponseEntity<TeacherAssistantScheduler> schedule(

    ){

        teacherAssistantScheduler.intialize();
        return new ResponseEntity(HttpStatus.OK);
    }
}
