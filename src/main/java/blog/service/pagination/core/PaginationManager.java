package blog.service.pagination.core;

import blog.dao.GenericDAO;
import blog.dao.GenericHibernateDAOImpl;
import blog.service.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by Alex on 06.02.2015.
 */
@Transactional
public class PaginationManager<T, D extends GenericDAO<T>> implements Pagination<T> {

    public static final int FIRST_PAGE = 0;
    public static final int PAGE_SIZE = 10;

    private D dao;

    private int countPages(int items, int pageSize) {
        int pages;
//        if(pages == 0) throw new Exception();
        if (items <= pageSize) {
            pages = 1;
        } else if (items % pageSize == 0) {
            pages = items / pageSize;
        } else
            pages = items / pageSize + 1;
        return pages;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }

    @Override
    public Page<T> getPage(int fromPage, int pageSize) {
        int items = dao.getEntityCount();
        int pages = countPages(items, pageSize);
        return new Page<>(fromPage, pages, dao.getEntityGroup(fromPage, pageSize));
    }
}
