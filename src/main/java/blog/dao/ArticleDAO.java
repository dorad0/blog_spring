package blog.dao;

import blog.dao.exception.DaoException;
import blog.entity.Article;
import blog.entity.Comment;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface ArticleDAO extends GenericDAO<Article, Long> {

    Set<Comment> getComments(Long id) throws DaoException;

    List<Calendar> getDates() throws DaoException;

    List<Article> findByMonthAndYear(Calendar date) throws DaoException;

    Article getInitializedArticleById(Long id) throws DaoException;

    Long getCount(Calendar date) throws DaoException;

    List<Article> findAll(int firstResult, int maxResults, Calendar date) throws DaoException;

}

