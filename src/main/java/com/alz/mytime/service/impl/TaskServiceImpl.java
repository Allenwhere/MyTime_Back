package com.alz.mytime.service.impl;

import com.alz.mytime.domain.dto.TaskDTO;
import com.alz.mytime.domain.entity.Task;
import com.alz.mytime.exception.ResourceNotFoundException;
import com.alz.mytime.repository.TaskRepository;
import com.alz.mytime.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) { this.taskRepository = taskRepository;}


    @Override
    public TaskDTO getById(Integer id) {
        Task task = taskRepository.getById(id);
        if(task==null) {throw new ResourceNotFoundException("");}
        return new TaskDTO(task);
    }

    @Override
    public Collection<TaskDTO> getALl() {
        return taskRepository.getAll()
                .stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
    }


    @Transactional
    @Override
    public int save(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public int update(Task task, Integer id) {
        int res = taskRepository.update(task, id);
        if(res == -1) {
            throw new ResourceNotFoundException("Resource Not Found");
        }
        return res;
    }
    @Transactional
    @Override
    public int removeById(Integer id) {
        int res = taskRepository.removeById(id);
        if(res == -1) {
            throw new ResourceNotFoundException("Resource Not Found");
        }
        return res;
    }
}
