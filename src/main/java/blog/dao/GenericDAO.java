package blog.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
public interface GenericDAO<T, ID extends Serializable> {
    Long save(T entity);

    void delete(T entity);

    void delete(ID id);

    void update(T entity);

    T findById(ID id);

    List<T> findAll();

    List<T> findAll(int firstResult, int maxResults);

    Long getCount();
}
