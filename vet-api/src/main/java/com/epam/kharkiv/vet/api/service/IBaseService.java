package com.epam.kharkiv.vet.api.service;

import java.util.List;

/**
 * Basic service will dinamically handle all requests by it`s implementation
 * 
 * @author Maksym_Nebliienko
 *
 * @param <T> Class of domain object
 */
public interface IBaseService<T> {

    /**
     * Gets all object and returns to client
     * 
     * @return object of specified by implementation class
     */
    List<T> get();

    /**
     * Gets object from repository and gives to the client
     * 
     * @param id id of requested object
     * @return requested object by its id
     */
    T get(String id);

    /**
     * Inserts object into repository
     * 
     * @param obj object to be inserted
     */
    void insert(T obj);

    /**
     * Updates object in repository
     * 
     * @param obj object to be updated
     */
    void update(T obj);

    /**
     * Deletes object by it`s specified id
     * 
     * @param id id of the object to be deleted
     */
    void delete(String id);
}
