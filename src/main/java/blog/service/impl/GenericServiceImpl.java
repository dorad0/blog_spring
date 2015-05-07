package blog.service.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.GenericDAO;
import blog.service.GenericService;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class GenericServiceImpl<ID extends Serializable, T, D extends GenericDAO<T, ID>> implements GenericService<T, ID> {

    protected D genericDAO;

    protected void setGenericDAO(D genericDAO) {
        this.genericDAO = genericDAO;
    }

    @ExceptionTranslation
    @Override
    public Long save(T entity) {
        return genericDAO.save(entity);
    }

    @ExceptionTranslation
    @Override
    public void delete(T entity) {
        genericDAO.delete(entity);
    }

    @ExceptionTranslation
    @Override
    public void delete(ID id) {
        genericDAO.delete(id);
    }

    @ExceptionTranslation
    @Override
    public void update(T entity) {
        genericDAO.update(entity);
    }

    @ExceptionTranslation
    @Override
    public T findById(ID id) {
        return genericDAO.findById(id);
    }

    @ExceptionTranslation
    @Override
    public List<T> findAll() {
        return genericDAO.findAll();
    }

    @ExceptionTranslation
    @Override
    public List<T> findAll(int firstResult, int maxResults) {
        return genericDAO.findAll(firstResult, maxResults);
    }

    @ExceptionTranslation
    @Override
    public Long getCount() {
        return genericDAO.getCount();
    }

}
