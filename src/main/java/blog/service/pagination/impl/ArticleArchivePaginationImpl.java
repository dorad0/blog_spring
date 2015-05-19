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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by alex on 3/18/2015.
 */
@Service
@Transactional
public class ArticleArchivePaginationImpl extends PaginationManager<Article, Long, ArticleDAO> implements ArticleArchivePagination {

    @Override
    @Autowired
    public void setDao(@Qualifier("ArticleDAOImpl") ArticleDAO dao) {
        super.setDao(dao);
    }

    @Override
    public Page<Article> getPage(int pageNumber, int pageSize, int year, int month) {
        setPageSize(pageSize);
        int items = dao.getCount(year, month).intValue();
        int fromElement = DEFAULT_FIRST_ELEMENT;
        int pages = countPages(items, pageSize);
//        if(pageNumber <= 0 || pageNumber > pages)
//            throw new Exception();
        this.pageSize = pageSize;
        if (pageNumber <= 0 || pageNumber > pages)
            pageNumber = DEFAULT_FIRST_ELEMENT;
        if (pageNumber > 1) {
            fromElement = (pageNumber - 1) * pageSize;
            return new Page<>(pageNumber, pages, dao.findAll(fromElement, pageSize, year, month));
        }
        return new Page<>(pageNumber, pages, dao.findAll(fromElement, pageSize, year, month));
    }


    @Override
    public Page<Article> getPage(int pageNumber, int year, int month) {
        return getPage(pageNumber, pageSize, year, month);
    }

}
