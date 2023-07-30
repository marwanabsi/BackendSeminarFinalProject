package com.Graduation.TeacherAssistantProject.Notfications.Controllers;


import com.Graduation.TeacherAssistantProject.Scheduling.Schedue.TeacherAssistantScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/Notifcations")
@RequiredArgsConstructor
public class NotifcationController {

    private final TeacherAssistantScheduler teacherAssistantScheduler;

    @GetMapping("/SendNotifcation")
    public ResponseEntity<TeacherAssistantScheduler> schedule(

    ){

        teacherAssistantScheduler.intialize();
        return new ResponseEntity(HttpStatus.OK);
    }
}