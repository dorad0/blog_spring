package blog.service;

import blog.dao.GenericDAO;

import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
public interface GenericManager<T> {
    Long save(T entity);

    void update(T entity);

    void delete(T entity);

    void delete(Long id);

    T findById(Long id);

    List<T> findAll();

    List<T> findAll(int firstResult, int maxResults);

    Long getCount();
}
