package blog.service;

import blog.entity.Article;
import blog.entity.Comment;
import blog.service.forms.ArticleForm;
import blog.service.pagination.ArticleArchivePagination;
import blog.service.pagination.ArticlePagination;
import org.springframework.security.core.userdetails.User;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface ArticleService extends GenericService<Article, Long> {

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
