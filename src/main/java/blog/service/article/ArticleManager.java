package blog.service.article;

import blog.dao.ArticleDAO;
import blog.entity.Article;
import blog.service.article.web.ArticleForm;
import blog.service.pagination.Pageable;
import blog.service.pagination.article.ArticleArchivePagination;
import blog.service.pagination.article.ArticlePagination;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Alex on 05.02.2015.
 */
public interface ArticleManager  extends ArticleDAO {
    void save(Article article, String userName);

    void save(Article article, User user);

    void deleteById(long id);

    Article save(ArticleForm form, User user);

    Article getInitializedArticleById(long id);

    ArticlePagination getPagination();

    ArticleArchivePagination getArchivePagination();
}
