package com.edu_verse.api_edu_verse.model;

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

    private List<String> classes;

    @OneToMany(mappedBy = "teacher")

    private List<Tasks> tasks;
}
