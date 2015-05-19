package blog.dao;

import blog.dao.exception.DaoException;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

    Long save(T entity) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(T entity) throws DaoException;

    Long delete(ID id) throws DaoException;

    T findById(ID id) throws DaoException;

    List<T> findAll() throws DaoException;

    List<T> findAll(int firstResult, int maxResults) throws DaoException;

    Long getCount() throws DaoException;

}
