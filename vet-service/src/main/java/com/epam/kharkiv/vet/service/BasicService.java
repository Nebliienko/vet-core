package com.epam.kharkiv.vet.service;

import com.epam.kharkiv.vet.api.service.IBaseService;
import com.epam.kharkiv.vet.api.repository.IBaseRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Basic implementation of service
 * 
 * @author Maksym_Nebliienko
 *
 * @param <T> class of domain object
 */
public abstract class BasicService<T> implements IBaseService<T> {

    @Autowired
    protected IBaseRepository<T> repository;

    @Override
    public List<T> get() {
        return repository.get();
    }

    @Override
    public T get(String id) {
        return repository.get(id);
    }

    @Override
    public void insert(T obj) {
        repository.insert(obj);
    }

    @Override
    public void update(T obj) {
        repository.update(obj);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

}
