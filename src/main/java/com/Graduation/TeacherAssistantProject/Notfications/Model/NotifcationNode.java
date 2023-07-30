package com.Graduation.TeacherAssistantProject.Notfications.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data  //makes getters and setters by default
@Builder //
@AllArgsConstructor
@NoArgsConstructor
@Table(name="NotifcationNode")
public class NotifcationNode {

    @Id
    @GeneratedValue()
    int id;
    String sender;
    String target;
    Date updatedAt;
    String body;
}
