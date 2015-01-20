package blog.dao;


import blog.model.Article;
import blog.model.Comment;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 19.12.2014.
 */
public interface ArticleDAO {

    public void addArticle(Article article);

    public void deleteArticle(Article article);

    public Article getArticleById(long id);

    public Set<Comment> getComments(long id);

    public List<Article> getAllArticles();
}

