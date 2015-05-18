package com.epam.kharkiv.vet.repository;

import com.epam.kharkiv.vet.api.repository.IBaseRepository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Basic realization of repository
 * 
 * @author Maksym_Nebliienko
 *
 * @param <T>
 */
public abstract class BaseRepository<T> implements IBaseRepository<T> {

    /**
     * Sql session template.
     */
    @Autowired
    private SqlSessionTemplate template;

    /**
     * Gets mybatis template.
     * 
     * @return mybatis template.
     */
    protected SqlSessionTemplate getTemplate() {
        return template;
    }

    /**
     * Return namespace of xml mapper for each repository.
     * 
     * @return namespace
     */
    protected abstract String getNamespace();

    @Override
    public List<T> get() {
        return template.selectList(getNamespace() + ".getList");
    }

    @Override
    public T get(String id) {
        return template.selectOne(getNamespace() + ".get", id);
    }

    @Override
    public void insert(T obj) {
        template.insert(getNamespace() + ".insert", obj);
    }

    @Override
    public void update(T obj) {
        template.update(getNamespace() + ".update", obj);
    }

    @Override
    public void delete(String id) {
        template.delete(getNamespace() + ".delete", id);
    }
}
