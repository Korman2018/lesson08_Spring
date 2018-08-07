package com.library.DAO.Impl;

import com.library.DAO.BasicDAO;
import com.library.model.Entity;

import java.util.*;

public abstract class AbstractDAO<T extends Entity> implements BasicDAO<T> {

    private long nextId;

    private Map<Long, T> map;


    public AbstractDAO() {
        map = new HashMap<>();
        nextId = 1;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public T getById(long id) {
        return map.get(id);
    }

    @Override
    public long add(T entity) {
        long id = getNextId();

        entity.setId(id);
        map.put(id, entity);
        return id;
    }

    @Override
    public T set(T entity) {
        return map.put(entity.getId(), entity);
    }

    @Override
    public T delete(long id) {
        return map.remove(id);
    }

    @Override
    public long getNextId() {
        return nextId++;
    }
}
