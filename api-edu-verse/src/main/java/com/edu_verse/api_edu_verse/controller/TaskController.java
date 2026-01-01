package com.edu_verse.api_edu_verse.controller;

import com.edu_verse.api_edu_verse.model.Task;
import com.edu_verse.api_edu_verse.repository.TaskRepository;
import com.edu_verse.api_edu_verse.service.cookieServiceTeacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private cookieServiceTeacher cookieServiceTeacher;

    @GetMapping("/get-task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok(task)) // Se achar, retorna 200 OK e a tarefa
                .orElse(ResponseEntity.notFound().build()); // Se não achar, retorna 404
    }

    @PostMapping("/new-task")
    public ResponseEntity<Task> newTask(
            @RequestBody Task task,
            @CookieValue(value = "auth_token", defaultValue = "") String token
    ){
        if(!cookieServiceTeacher.isCookieValid_teacher(token)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Task saveTask = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveTask);
    }

    @PostMapping("/update_task/{id}")
    public ResponseEntity<Task> updateTask(
            @RequestBody Task task,
            @PathVariable Long id,
            @CookieValue(value = "auth_token", defaultValue = "") String token)
    {
        if(!cookieServiceTeacher.isCookieValid_teacher(token)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if(!taskRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Task updateTask = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.OK).body(updateTask);
    }



}
