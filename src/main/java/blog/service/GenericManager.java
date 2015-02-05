package blog.service;

import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
public interface GenericManager<T> {

    public void save(T entity);

    public void delete(T entity);

    public void update(T entity);

    public T findById(long id);

    public List<T> findAll();

    public int getEntityCount();

    public List<T> getEntityGroup(int fIndex, int groupSize);
}
