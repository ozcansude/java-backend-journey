package com.ozcansude.practice.expense.repository;

import java.util.List;

public interface Repository<T, ID> {

    void save(T entity);

    T findById(ID id);

    List<T> findAll();

    boolean deleteById(ID id);

    boolean update(ID id, T entity);
}