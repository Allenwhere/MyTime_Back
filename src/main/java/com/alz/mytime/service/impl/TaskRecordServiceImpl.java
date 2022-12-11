package com.alz.mytime.service.impl;

import com.alz.mytime.domain.dto.TaskRecordDTO;
import com.alz.mytime.domain.entity.TaskRecord;
import com.alz.mytime.exception.ResourceNotFoundException;
import com.alz.mytime.repository.Impl.TaskRecordRepositoryImpl;
import com.alz.mytime.repository.TaskRecordRepository;
import com.alz.mytime.service.TaskRecordService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {
    private final TaskRecordRepositoryImpl taskRecordRepository;

    public TaskRecordServiceImpl(TaskRecordRepositoryImpl taskRecordRepository) {
        this.taskRecordRepository = taskRecordRepository;
    }


    @Override
    public TaskRecordDTO getById(Integer id) {
        return new TaskRecordDTO(taskRecordRepository.getById(id));
    }

    @Override
    public Collection<TaskRecordDTO> getAllRecordsOfTask(Integer id) {
        return taskRecordRepository.getAllRecordsOfTask(id)
                .stream()
                .map(TaskRecordDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public int save(TaskRecord taskRecord) {
        return taskRecordRepository.save(taskRecord);
    }

    @Transactional
    @Override
    public int update(TaskRecord taskRecord, Integer id) {
        int res =taskRecordRepository.removeById(id);
        if(res == -1) {
            throw new ResourceNotFoundException("Resource Not Found");
        }
        return res;
    }

    @Transactional
    @Override
    public int removeById(Integer id) {
        int res =taskRecordRepository.removeById(id);
        if(res == -1) {
            throw new ResourceNotFoundException("Resource Not Found");
        }
        return res;
    }
}
