package com.Graduation.TeacherAssistantProject.Course.Services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseClassRequest {
    private String course;
    private String field;
    private String startTime;
    private String endTime;
}
