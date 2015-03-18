package blog.service.pagination.article;

import blog.entity.Article;
import blog.service.pagination.core.Page;
import blog.service.pagination.core.Pagination;

import java.util.Calendar;

/**
 * Created by Alex on 06.02.2015.
 */
public interface ArticlePagination extends Pagination<Article> {
    Page<Article> getPage(int pageNumber, int pageSize, Calendar date);
    Page<Article> getPage(int pageNumber, Calendar date);
    Page<Article> getFirstPage(Calendar date);
    Page<Article> getPage(int pageNumber, int pageSize, int year, int month);
    Page<Article> getPage(int pageNumber, int year, int month);
}
