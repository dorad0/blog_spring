package blog.service.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.GenericDAO;
import blog.dao.exception.DaoException;
import blog.service.GenericService;
import blog.service.exception.ServiceException;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class GenericServiceImpl<ID extends Serializable, T, D extends GenericDAO<T, ID>> implements GenericService<T, ID> {

    protected D dao;

    protected void setDao(D dao) {
        this.dao = dao;
    }

    @ExceptionTranslation
    @Override
    public Long save(T entity) {
        return dao.save(entity);
    }

    @ExceptionTranslation
    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @ExceptionTranslation
    @Override
    public void delete(ID id) {
        dao.delete(id);
    }

    @ExceptionTranslation
    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @ExceptionTranslation
    @Override
    public T findById(ID id) {
        return dao.findById(id);
    }

    @ExceptionTranslation
    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @ExceptionTranslation
    @Override
    public List<T> findAll(int firstResult, int maxResults) {
        return dao.findAll(firstResult, maxResults);
    }

    @ExceptionTranslation
    @Override
    public Long getCount() {
        return dao.getCount();
    }

}
