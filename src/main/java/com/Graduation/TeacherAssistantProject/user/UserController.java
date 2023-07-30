package com.Graduation.TeacherAssistantProject.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping("/{id}")
    public ResponseEntity<User> getTeacherAssInfo(@PathVariable String id) {
        User user = service.getUserInfoById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}