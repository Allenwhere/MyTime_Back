package com.alz.mytime.repository;

import com.alz.mytime.domain.entity.TaskRecord;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaskRecordRepository {

    TaskRecord getById(Integer id);

    Collection<TaskRecord> getAllRecordsOfTask(Integer id);

    int save(TaskRecord taskRecord);
    int update(TaskRecord taskRecord, Integer id);
    int removeById(Integer id);
}
