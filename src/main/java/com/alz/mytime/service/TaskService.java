package com.alz.mytime.service;

import com.alz.mytime.domain.dto.TaskDTO;
import com.alz.mytime.domain.entity.Task;

import java.util.Collection;

public interface TaskService {
    TaskDTO getById(Integer id);

    Collection<TaskDTO> getALl();

    int save(Task task);

    int update(Task task, Integer id);
    int removeById(Integer id);


}
