package com.Graduation.TeacherAssistantProject.Notfications.Model;

import com.Graduation.TeacherAssistantProject.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Date;

@Entity
@Data  //makes getters and setters by default
@Builder //
@AllArgsConstructor
@NoArgsConstructor
@Table(name="NotifcationBar")
public class NotifcationBar {

    @Id
    @GeneratedValue()
    int id;
    String hi;
    //todo
//    @OneToMany
//    List<NotifcationNode> notifcations;

//    //todo
//    @OneToOne
//    User user;




}