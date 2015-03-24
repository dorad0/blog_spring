package blog.service.pagination.article;

import blog.entity.Article;
import blog.service.pagination.core.Page;

import java.util.Calendar;

/**
 * Created by alex on 3/18/2015.
 */
public interface ArticleArchivePagination {
    Page<Article> getPage(int pageNumber, int pageSize, Calendar date);

    Page<Article> getPage(int pageNumber, Calendar date);

    Page<Article> getFirstPage(Calendar date);

    Page<Article> getPage(int pageNumber, int pageSize, int year, int month);

    Page<Article> getPage(int pageNumber, int year, int month);
}
