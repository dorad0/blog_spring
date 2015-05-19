package blog.service;

import blog.service.exception.ServiceException;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {

    Long save(T entity) throws ServiceException;

    void update(T entity) throws ServiceException;

    void delete(T entity) throws ServiceException;

    void delete(ID id) throws ServiceException;

    T findById(ID id) throws ServiceException;

    List<T> findAll() throws ServiceException;

    List<T> findAll(int firstResult, int maxResults) throws ServiceException;

    Long getCount() throws ServiceException;

}
