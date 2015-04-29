package blog.dao.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.GenericDAO;
import blog.service.exception.ServiceException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Scope("prototype")
public abstract class GenericHibernateDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private final Class<T> genericType;

    @Autowired
    protected SessionFactory sessionFactory;

    public GenericHibernateDAOImpl() {
        this.genericType = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @ExceptionTranslation
    @Override
    public Long save(T entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @ExceptionTranslation
    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @ExceptionTranslation
    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @ExceptionTranslation
    @Override
    public void delete(ID id) {
        getCurrentSession().createSQLQuery("DELETE FROM " +  genericType.getName() +  "WHERE id = :id ").setParameter("id", id).executeUpdate();
    }

    @ExceptionTranslation
    @Override
    public T findById(ID id) {
        return (T) getCurrentSession().get(genericType, id);
    }

    @ExceptionTranslation
    @Override
    public List<T> findAll() {
        return getCurrentSession().createQuery("FROM " + genericType.getName()).list();
    }

    @ExceptionTranslation
    @Override
    public List<T> findAll(int firstResult, int maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(genericType);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);

        return criteria.list();
    }

    @ExceptionTranslation
    @Override
    public Long getCount() {
        Criteria criteriaCount = getCurrentSession().createCriteria(genericType);
        criteriaCount.setProjection(Projections.rowCount());

        return (Long) criteriaCount.uniqueResult();
    }

}