package com.edu_verse.api_edu_verse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "instituition")
public class Instituition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String email;

    private String password;

    private String phone_number;

    private String description;

    @OneToMany(mappedBy = "instituition")

    @ElementCollection
    private List<String> classes;

    @ManyToOne
    @JoinColumn(name="teacher")
    private Teacher teacher;

    @ElementCollection
    private List<String> students;

    private String salt;
}
