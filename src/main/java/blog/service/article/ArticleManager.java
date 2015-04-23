package blog.service.article;

import blog.entity.Article;
import blog.entity.Comment;
import blog.service.GenericManager;
import blog.service.article.web.ArticleForm;
import blog.service.pagination.article.ArticleArchivePagination;
import blog.service.pagination.article.ArticlePagination;
import org.springframework.security.core.userdetails.User;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 05.02.2015.
 */
public interface ArticleManager extends GenericManager<Article, Long> {
    Set<Comment> getComments(Long id);

    List<Calendar> getDates();

    Long getCount(Calendar date);

    List<Article> findByMonthAndYear(Calendar date);

    List<Article> findAll(int firstResult, int maxResults, Calendar date);

    void save(Article article, String userName);

    void save(Article article, User user);

    Article save(ArticleForm form, User user);

    Article getInitializedArticleById(Long id);

    ArticlePagination getPagination();

    ArticleArchivePagination getArchivePagination();
}
