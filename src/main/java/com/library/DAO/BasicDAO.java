package com.library.DAO;

import com.library.model.Entity;

import java.util.List;

public interface BasicDAO<T extends Entity> {

    List<T> getAll();

    T getById(long id);

    long add(T entity);

    T set(T entity);

    T delete(long id);

    long getNextId();
}
