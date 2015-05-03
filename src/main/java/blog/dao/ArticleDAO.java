package blog.dao;

import blog.dao.exception.DaoException;
import blog.entity.Article;
import blog.entity.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface ArticleDAO extends GenericDAO<Article, Long> {

    Set<Comment> getComments(Long id) throws DaoException;

    List<LocalDate> getDates() throws DaoException;

    List<Article> findByMonthAndYear(LocalDate date) throws DaoException;

    Article getInitializedArticleById(Long id) throws DaoException;

    Long getCount(LocalDate date) throws DaoException;

    List<Article> findAll(int firstResult, int maxResults, LocalDate date) throws DaoException;

}

