package com.Graduation.TeacherAssistantProject.Scheduling.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Schedule")
@RequiredArgsConstructor
public class ScheduleController {
    public ResponseEntity<String> Home(){

        return ResponseEntity.ok( "hello " ) ;
    }



}
