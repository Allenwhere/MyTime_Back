package com.alz.mytime.repository;

import com.alz.mytime.domain.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaskRepository {

    Task getById(Integer id);

    Collection<Task> getAll();

    int save(Task task);

    int update(Task task, Integer id);

    int removeById(Integer id);



}
