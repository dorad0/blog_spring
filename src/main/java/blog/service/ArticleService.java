package blog.service;

import blog.entity.Article;
import blog.entity.Comment;
import blog.service.exception.ServiceException;
import blog.service.forms.ArticleForm;
import blog.service.pagination.ArticleArchivePagination;
import blog.service.pagination.ArticlePagination;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface ArticleService extends GenericService<Article, Long> {

    Set<Comment> getComments(Long id) throws ServiceException;

    List<LocalDate> getDates() throws ServiceException;

    Long getCount(LocalDate date) throws ServiceException;

    List<Article> findByMonthAndYear(LocalDate date) throws ServiceException;

    List<Article> findAll(int firstResult, int maxResults, LocalDate date) throws ServiceException;

    void save(Article article, String userName) throws ServiceException;

    void save(Article article, User user) throws ServiceException;

    Article save(ArticleForm form, User user) throws ServiceException;

    Article getInitializedArticleById(Long id) throws ServiceException;

    ArticlePagination getPagination() throws ServiceException;

    ArticleArchivePagination getArchivePagination() throws ServiceException;

}
