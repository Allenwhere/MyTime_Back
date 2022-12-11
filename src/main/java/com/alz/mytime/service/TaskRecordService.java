package com.alz.mytime.service;


import com.alz.mytime.domain.dto.TaskRecordDTO;
import com.alz.mytime.domain.entity.TaskRecord;

import java.util.Collection;

public interface TaskRecordService {
    TaskRecordDTO getById(Integer id);

    Collection<TaskRecordDTO> getAllRecordsOfTask(Integer id);

    int save(TaskRecord taskRecord);

    int update(TaskRecord taskRecord, Integer id);

    int removeById(Integer id);
}
