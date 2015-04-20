package blog.dao;

import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
public interface GenericDAO<T> {
    Long save(T entity);

    void delete(T entity);

    void delete(Long id);

    void update(T entity);

    T findById(Long id);

    List<T> findAll();

    List<T> findAll(int firstResult, int maxResults);

    Long getCount();
}
