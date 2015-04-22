package blog.dao.impl;

import blog.dao.GenericDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Alex on 05.02.2015.
 */
@Scope("prototype")
public abstract class GenericHibernateDAOImpl<T extends Serializable> implements GenericDAO<T> {

    private final Class<T> genericType;

    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public GenericHibernateDAOImpl() {
        this.genericType = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public Long save(T entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void delete(Long id) {
        getCurrentSession().createSQLQuery("DELETE FROM " +  genericType.getName() +  "WHERE id = :id ").setParameter("id", id).executeUpdate();
    }

    @Override
    public T findById(Long id) {
        return (T) getCurrentSession().get(genericType, id);
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createQuery("FROM " + genericType.getName()).list();
    }

    @Override
    public List<T> findAll(int firstResult, int maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(genericType);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);

        return criteria.list();
    }

    @Override
    public Long getCount() {
        Criteria criteriaCount = getCurrentSession().createCriteria(genericType);
        criteriaCount.setProjection(Projections.rowCount());

        return (Long) criteriaCount.uniqueResult();
    }

}