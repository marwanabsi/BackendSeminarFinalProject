package com.Graduation.TeacherAssistantProject.Course.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
@Data  //makes getters and setters by default
@Builder //
@AllArgsConstructor
@NoArgsConstructor
public class CourseClass implements Comparable<CourseClass> {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = true)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = true)
    private Instructor instructor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherAssistant_id", nullable = true)
    private TeacherAssistant teacherAssistant;

    private Instructor HasInstructor() {
        if (this.instructor == null) {
            return null;
        }
        return this.instructor;
    }
    public boolean HasTA() {
        if (this.teacherAssistant != null) {
            return true;
        }
        return true;
    }
    //TODO debugging

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseDays> daysAndTimes = new ArrayList<>();
    


    public long TimeDifference(Date timestart, Date timeEnd) {
        long difference = timestart.getTime() - timeEnd.getTime();
        return difference;
    }

    @Override
    public int compareTo(CourseClass o) {
        if (this == o) {
            return 0;
        }
        if (o == null) {
            return 1;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime thisEarliestTimeStart = this.daysAndTimes.stream()
                .map(daysAndTime -> LocalTime.parse(daysAndTime.getStartTime(), formatter))
                .min(Comparator.naturalOrder())
                .orElse(null);

        LocalTime oEarliestTimeStart = o.daysAndTimes.stream()
                .map(daysAndTime -> LocalTime.parse(daysAndTime.getStartTime(), formatter))
                .min(Comparator.naturalOrder())
                .orElse(null);


        if (thisEarliestTimeStart != null && oEarliestTimeStart != null) {
            return thisEarliestTimeStart.compareTo(oEarliestTimeStart);
        } else if (thisEarliestTimeStart == null && oEarliestTimeStart != null) {
            return -1;
        } else if (thisEarliestTimeStart != null) {
            return 1;
        }

        return 0;
    }


}
