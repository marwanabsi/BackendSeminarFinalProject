package com.Graduation.TeacherAssistantProject.user;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User getUserInfoById(String Id) {
        User user = userRepository.findByEmail(Id)
                .orElseThrow(() -> new EntityNotFoundException("TeacherAssistant not found with ID: " + Id));

        return user;
    }





}
