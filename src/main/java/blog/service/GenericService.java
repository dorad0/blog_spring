package blog.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {

    Long save(T entity);

    void update(T entity);

    void delete(T entity);

    void delete(ID id);

    T findById(ID id);

    List<T> findAll();

    List<T> findAll(int firstResult, int maxResults);

    Long getCount();

}
