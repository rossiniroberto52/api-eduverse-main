package com.edu_verse.api_edu_verse.controller;

import com.edu_verse.api_edu_verse.dto.SchoolClassDTO;
import com.edu_verse.api_edu_verse.model.SchoolClass;
import com.edu_verse.api_edu_verse.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class SchoolClassController {

    @Autowired
    private SchoolClassService schoolClassService; // Injeta o Service, não o Repository

    @PostMapping
    public ResponseEntity<SchoolClass> create(@RequestBody SchoolClassDTO dto) {
        SchoolClass createdClass = schoolClassService.createClass(dto);
        return ResponseEntity.ok(createdClass);
    }

    @GetMapping
    public ResponseEntity<List<SchoolClass>> getAll() {
        return ResponseEntity.ok(schoolClassService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolClass> getById(@PathVariable Long id) {
        return schoolClassService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}