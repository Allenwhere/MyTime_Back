package com.alz.mytime.repository.Impl;

import com.alz.mytime.domain.entity.TaskRecord;
import com.alz.mytime.repository.TaskRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class TaskRecordRepositoryImpl implements TaskRecordRepository {

    @Autowired
    private EntityManager em;
    @Override
    public TaskRecord getById(Integer id) {
        return em.find(TaskRecord.class,id);
    }

    @Override
    public Collection<TaskRecord> getAllRecordsOfTask(Integer id) {
        Query query = em.createQuery("select tr from TaskRecord tr where tr.task.id = :taskId");
        return query.setParameter("taskId", id).getResultList();
    }

    @Override
    public int save(TaskRecord taskRecord) {
        TaskRecord tr = em.merge(taskRecord);
        return tr.getId();
    }

    @Override
    public int update(TaskRecord taskRecord, Integer id) {
        return save(taskRecord);
    }

    @Override
    public int removeById(Integer id) {
        TaskRecord tr = getById(id);
        if(tr == null) {
            return -1;
        }
        em.remove(tr);
        return id;
    }
}
