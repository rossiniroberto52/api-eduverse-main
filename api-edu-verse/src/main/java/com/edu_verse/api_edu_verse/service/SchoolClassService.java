package com.edu_verse.api_edu_verse.service;

import com.edu_verse.api_edu_verse.dto.SchoolClassDTO;
import com.edu_verse.api_edu_verse.model.SchoolClass;
import com.edu_verse.api_edu_verse.model.Teacher;
import com.edu_verse.api_edu_verse.repository.SchoolClassRepository;
import com.edu_verse.api_edu_verse.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Obrigatório para o Spring saber que isso é injetável
public class SchoolClassService {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public SchoolClass createClass(SchoolClassDTO dto) {
        // Regra de Negócio 1: O professor precisa existir
        Teacher teacher = teacherRepository.findById(dto.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com ID: " + dto.getTeacherId()));

        // Regra de Negócio 2: Conversão DTO -> Entity
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName(dto.getName());
        schoolClass.setDescription(dto.getDescription());
        schoolClass.setTeacher(teacher);

        return schoolClassRepository.save(schoolClass);
    }

    public List<SchoolClass> findAll() {
        return schoolClassRepository.findAll();
    }

    public Optional<SchoolClass> findById(Long id) {
        return schoolClassRepository.findById(id);
    }
}