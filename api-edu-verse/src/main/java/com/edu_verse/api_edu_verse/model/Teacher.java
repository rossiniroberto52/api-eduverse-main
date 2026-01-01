package com.edu_verse.api_edu_verse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    private String email;

    private String password;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonIgnore // CRÍTICO: Impede loop infinito ao converter para JSON
    private List<SchoolClass> schoolClasses;

    @OneToMany(mappedBy = "teacher")

    private List<Task> tasks;
}
