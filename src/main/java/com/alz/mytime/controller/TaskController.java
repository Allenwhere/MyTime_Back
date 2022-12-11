package com.alz.mytime.controller;

import com.alz.mytime.domain.dto.TaskDTO;
import com.alz.mytime.domain.entity.Task;
import com.alz.mytime.exception.CommonErrorResponse;
import com.alz.mytime.exception.ResourceNotFoundException;
import com.alz.mytime.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    private  final TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable Integer taskId) {
        return new ResponseEntity<>(taskService.getById(taskId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTasks() {
        return new ResponseEntity<>(taskService.getALl(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.save(task),HttpStatus.CREATED);
    }

    @PutMapping("/{taskId}")
    public  ResponseEntity<?> updateTask(@RequestBody Task task, @PathVariable Integer taskId) {
        return new ResponseEntity<>(taskService.update(task, taskId), HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer taskId) {
        return new ResponseEntity<>(taskService.removeById(taskId), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("Resource Not Found"), HttpStatus.NOT_FOUND);
    }

}
