package blog.service;

import blog.model.Article;
import blog.model.User;

import java.util.List;

/**
 * Created by user on 27.01.2015.
 */
public interface ArticleService {

    void saveArticle(Article article, String userName);

    Article getArticleById(long id);

    public List<Article> getArticles();
}
