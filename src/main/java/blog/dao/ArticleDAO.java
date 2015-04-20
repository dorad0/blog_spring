package blog.dao;

import blog.entity.Article;
import blog.entity.Comment;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 19.12.2014.
 */
public interface ArticleDAO extends GenericDAO<Article> {
    Set<Comment> getComments(Long id);

    List<Calendar> getDates();

    List<Article> findByMonthAndYear(Calendar date);

    void deleteById(Long id);

    Article saveAndGet(Article article);

    Article getInitializedArticleById(Long id);

    int getEntityCount(Calendar date);

    List<Article> getEntityGroup(int firstResult, int maxResults, Calendar date);
}

