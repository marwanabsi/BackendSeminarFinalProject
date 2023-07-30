package com.Graduation.TeacherAssistantProject.Course.Services;


import com.Graduation.TeacherAssistantProject.Course.Models.TeacherLoad;
import com.Graduation.TeacherAssistantProject.Course.Repositories.TeacherAssistantRepo;
import com.Graduation.TeacherAssistantProject.Course.Repositories.TeacherLoadReop;
import com.Graduation.TeacherAssistantProject.Course.Models.Course;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;
import com.Graduation.TeacherAssistantProject.Course.Models.TeacherLoadDTO;
import com.Graduation.TeacherAssistantProject.Course.Repositories.CourseRepo;
import com.Graduation.TeacherAssistantProject.Scheduling.evaluation.Evaluation;
import com.Graduation.TeacherAssistantProject.Scheduling.evaluation.EvaluationRepo;
import com.Graduation.TeacherAssistantProject.user.Role;
import com.Graduation.TeacherAssistantProject.user.User;
import com.Graduation.TeacherAssistantProject.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherAssistantService {

    private final TeacherAssistantRepo teacherAssistantRepo;
    private final EvaluationRepo evaluationRepo;
    private final CourseRepo courseRepo;
    private final TeacherLoadReop teacherLoadReop;
    private final UserRepository userRepository;
    User user;
    public ResponseEntity RegisterTeacher(TeacherAssistantRequest request) {
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            username= currentUserName;
        }

        var user = userRepository.findByEmail(username).orElseThrow();

        var  teacherAssistant = TeacherAssistant.builder()
                .name(request.getName())
                .isAvailable(request.isAvailable())
                .isFulltime(request.isFulltime()).loadHours(request.getPreferedLoad()).user(user)
                .build();


       // teacherAssistantRepo.save(teacherAssistant);
        var evaluation = Evaluation.builder().
                isInRamallah(request.isInRamallah()).
                experienceClassesNumber(request.getExperienceClassesNumber()).
                isPartTime(request.isPartTime()).
                isScholarship(request.isScholarship()).
                ExperienceYears(request.getExperienceYears()).VacationDay(request.getVacationDay()).
                isFullTimeScholarShip(request.isFullTimeScholarShip()).
                isPartTimeScholarShip(request.isPartTimeScholarShip()).
                preferedLabsLoad(request.getPreferedLoad()).teacherAssistant(teacherAssistant).build();

        evaluation.setTeacherAssistant(teacherAssistant);

        Course course = new Course();
        List<Course> courseList = new ArrayList<Course>();
        for(int i = 0; i < request.getCourseList().size();i++){
            course =  courseRepo.findByName(request.getCourseList().get(i));
            courseList.add(course);
        }
        evaluation.setCourseList(courseList);

        evaluationRepo.save(evaluation);

        teacherAssistant.setEvaluation(evaluation);

        if(user.getRole().equals(Role.USER)){
            user.setTeacherAssistant(teacherAssistant);
        }
        else {
            teacherAssistantRepo.save(teacherAssistant);
        }
        userRepository.save(user);
        this.user=user;
        return ResponseEntity.ok( "Done" ) ;


    }

    public List<TeacherLoadDTO> getAllTeacherLoadsByAssistantId(int assistantId) {
        TeacherAssistant teacherAssistant = teacherAssistantRepo.findById(assistantId).orElse(null);
        List<TeacherLoad> teacherLoadList = teacherLoadReop.getteacherload(teacherAssistant);

        List<TeacherLoadDTO> teacherLoadDTOList = new ArrayList<>();

        for (TeacherLoad teacherLoad : teacherLoadList) {
            TeacherLoadDTO teacherLoadDTO = new TeacherLoadDTO();
            teacherLoadDTO.setId(teacherLoad.getId());
            teacherLoadDTO.setDay(teacherLoad.getDay());
            teacherLoadDTO.setStartTime(teacherLoad.getStartTime());
            teacherLoadDTO.setEndTime(teacherLoad.getEndTime());
            teacherLoadDTO.setCourseName(teacherLoad.getCourse().getCourse().getName());
            // Set other fields if needed

            teacherLoadDTOList.add(teacherLoadDTO);
        }

        return teacherLoadDTOList;
    }



    public TeacherAssistant getTeacherAssInfo(int assistantId) {
        TeacherAssistant teacherAssistant = teacherAssistantRepo.findById(assistantId)
                .orElseThrow(() -> new EntityNotFoundException("TeacherAssistant not found with ID: " + assistantId));

        return teacherAssistant;
    }

    public List<TeacherLoadDTO> GetTeacherUsingUser(){
        if(this.user!=null){
           return getAllTeacherLoadsByAssistantId(user.getTeacherAssistant().getId());
        }
        return null;
    }

}
