package com.alz.mytime.repository.Impl;

import com.alz.mytime.domain.entity.Task;
import com.alz.mytime.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    @Autowired
    private EntityManager em;

    @Override
    public Task getById(Integer id) {
        return em.find(Task.class, id);
    }

    @Override
    public Collection<Task> getAll() {
        Query query = em.createQuery("select t from Task t");
        return query.getResultList();
    }

    @Override
    public int save(Task task) {
        Task t = em.merge(task);
        return t.getId();
    }

    @Override
    public int update(Task task, Integer id) {
        return save(task);
    }

    @Override
    public int removeById(Integer id) {
        Task t = getById(id);
        if(t == null) {
            return -1;
        }
        em.remove(t);
        return id;
    }
}
