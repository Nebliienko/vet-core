package com.epam.kharkiv.vet.api.repository;

import java.util.List;

/**
 * Basic repository that will dynamically handle requests of specified type.
 * 
 * @author Maksym_Nebliienko
 *
 * @param <T> Class of domain object
 */
public interface IBaseRepository<T> {

    /**
     * Gets all objects from data storage and returns to client
     * 
     * @return object of specified by implementation class
     */
    List<T> get();

    /**
     * Gets object from data storage from repository and gives to the client
     * 
     * @param id id of requested object
     * @return requested object by its id
     */
    T get(String id);

    /**
     * Inserts object into data storage
     * 
     * @param obj object to be inserted
     */
    void insert(T obj);

    /**
     * Updates object in data storage
     * 
     * @param obj object to be updated
     */
    void update(T obj);

    /**
     * Deletes object by it`s specified id from data storage
     * 
     * @param id id of the object to be deleted
     */
    void delete(String id);
}
