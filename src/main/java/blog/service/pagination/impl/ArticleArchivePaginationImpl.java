package blog.service.pagination.impl;

import blog.dao.ArticleDAO;
import blog.entity.Article;
import blog.service.pagination.ArticleArchivePagination;
import blog.service.pagination.core.Page;
import blog.service.pagination.core.PaginationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by alex on 3/18/2015.
 */
@Service
@Transactional
public class ArticleArchivePaginationImpl extends PaginationManager<Article, Long, ArticleDAO> implements ArticleArchivePagination {

    public static final int FIRST_DAY_OF_MONTH = 1;

    @Override
    @Autowired
    public void setDao(@Qualifier("ArticleDAOImpl") ArticleDAO dao) {
        super.setDao(dao);
    }

    @Override
    public Page<Article> getPage(int pageNumber, int pageSize, Calendar date) {
        setPageSize(pageSize);
        int items = dao.getCount(date).intValue();
        int fromElement = DEFAULT_FIRST_ELEMENT;
        int pages = countPages(items, pageSize);
//        if(pageNumber <= 0 || pageNumber > pages)
//            throw new Exception();
        this.pageSize = pageSize;
        if (pageNumber <= 0 || pageNumber > pages)
            pageNumber = DEFAULT_FIRST_ELEMENT;
        if (pageNumber > 1) {
            fromElement = (pageNumber - 1) * pageSize;
            return new Page<>(pageNumber, pages, dao.findAll(fromElement, pageSize, date));
        }
        return new Page<>(pageNumber, pages, dao.findAll(fromElement, pageSize, date));
    }

    @Override
    public Page<Article> getPage(int pageNumber, Calendar date) {
        return getPage(pageNumber, pageSize, date);
    }

    @Override
    public Page<Article> getFirstPage(Calendar date) {
        return getPage(DEFAULT_FIRST_PAGE_NUMBER, date);
    }

    @Override
    public Page<Article> getPage(int pageNumber, int pageSize, int year, int month) {
        Calendar date = new GregorianCalendar(year, month, FIRST_DAY_OF_MONTH);
        return getPage(pageNumber, date);
    }

    @Override
    public Page<Article> getPage(int pageNumber, int year, int month) {
        return getPage(pageNumber, pageSize, year, month);
    }
}
