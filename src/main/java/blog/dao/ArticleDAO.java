package blog.dao;

import blog.entity.Article;
import blog.entity.Comment;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface ArticleDAO extends GenericDAO<Article, Long> {

    Set<Comment> getComments(Long id);

    List<Calendar> getDates();

    List<Article> findByMonthAndYear(Calendar date);

    Article getInitializedArticleById(Long id);

    Long getCount(Calendar date);

    List<Article> findAll(int firstResult, int maxResults, Calendar date);

}

