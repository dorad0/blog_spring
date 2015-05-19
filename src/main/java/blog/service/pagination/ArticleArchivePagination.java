package blog.service.pagination;

import blog.entity.Article;
import blog.service.pagination.core.Page;

import java.time.LocalDate;
import java.util.Calendar;

public interface ArticleArchivePagination {

//    Page<Article> getPage(int pageNumber, int pageSize, LocalDate date);

//    Page<Article> getPage(int pageNumber, LocalDate  date);

//    Page<Article> getFirstPage(LocalDate  date);

    Page<Article> getPage(int pageNumber, int pageSize, int year, int month);

    Page<Article> getPage(int pageNumber, int year, int month);

}
