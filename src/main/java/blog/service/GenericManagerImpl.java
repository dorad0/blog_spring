package blog.service;

import blog.dao.GenericDAO;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */

@Transactional
public abstract class GenericManagerImpl<T, D extends GenericDAO<T>> implements GenericManager<T> {

    protected D dao;

    protected void setDao(D dao) {
        this.dao = dao;
    }

    @Override
    public Long save(T entity) {
        return dao.save(entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public T findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public List<T> findAll(int firstResult, int maxResults) {
        return dao.findAll(firstResult, maxResults);
    }

    @Override
    public Long getCount() {
        return dao.getCount();
    }
}
