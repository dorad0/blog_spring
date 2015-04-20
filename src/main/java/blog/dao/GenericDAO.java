package blog.dao;

import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
public interface GenericDAO<T> {
    void save(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(long id);

    List<T> findAll();

    int getEntityCount();

    List<T> getEntityGroup(int fIndex, int groupSize);
}
