package com.alz.mytime.controller;

import com.alz.mytime.domain.entity.Task;
import com.alz.mytime.domain.entity.TaskRecord;
import com.alz.mytime.exception.CommonErrorResponse;
import com.alz.mytime.exception.ResourceNotFoundException;
import com.alz.mytime.repository.Impl.TaskRepositoryImpl;
import com.alz.mytime.service.impl.TaskRecordServiceImpl;
import com.alz.mytime.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task-record")
public class TaskRecordController {
    private final TaskRecordServiceImpl taskRecordService;
    private final TaskRepositoryImpl taskRepository;

    @Autowired
    public TaskRecordController(TaskRecordServiceImpl taskRecordService, TaskRepositoryImpl taskRepository) {
        this.taskRecordService = taskRecordService;
        this.taskRepository = taskRepository;
    }




    @GetMapping
    public ResponseEntity<?> getALlRecordsOfTask(@RequestParam Integer task_id) {
        return new ResponseEntity<>(taskRecordService.getAllRecordsOfTask(task_id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> createRecord(@RequestBody TaskRecord taskRecord, @RequestParam Integer task_id) {
        Task task = taskRepository.getById(task_id);
        if(task == null) {throw new ResourceNotFoundException("Not Found");}
        taskRecord.setTask(task);
        return new ResponseEntity<>(taskRecordService.save(taskRecord), HttpStatus.CREATED);
    }

    @DeleteMapping("/{taskRecordId}")
    public ResponseEntity<?> removeRecordById(@PathVariable Integer taskRecordId) {
        return new ResponseEntity<>(taskRecordService.removeById(taskRecordId), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("Resource Not Found"), HttpStatus.NOT_FOUND);
    }
}
