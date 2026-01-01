package com.edu_verse.api_edu_verse.controller;

import com.edu_verse.api_edu_verse.model.Teacher; // Importe seu Model
import com.edu_verse.api_edu_verse.repository.TeacherRepository; // Importe seu Repository (crie se não tiver)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher") // <--- Define o prefixo da URL
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    // A URL final será: /teacher/new-teacher
    @PostMapping("/new-teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        // Salva no banco
        Teacher savedTeacher = teacherRepository.save(teacher);

        // Retorna 200 OK com o professor criado
        return ResponseEntity.ok(savedTeacher);
    }


}