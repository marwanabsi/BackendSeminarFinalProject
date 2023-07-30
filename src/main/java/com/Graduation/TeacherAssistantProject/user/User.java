package com.Graduation.TeacherAssistantProject.user;

import com.Graduation.TeacherAssistantProject.Course.Models.TeacherAssistant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data  //makes getters and setters by default
@Builder //
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "_user") //avoid duplication in database


public class User implements UserDetails {
@Id
@GeneratedValue()
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String pass;
    private int TeacherId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_teacher")
    private TeacherAssistant teacherAssistant;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
