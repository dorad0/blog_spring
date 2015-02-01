package blog.service;

import blog.dao.ArticleDAO;
import blog.dao.UserDAO;
import blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 20.01.2015.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public List<Article> getArticles() {
        return articleDAO.getAllArticles();
    }

    @Override
    @Transactional
    public void saveArticle(Article article, String userName) {
        article.setPublicationDate(new Date());
        article.setUser(userDAO.findByUserName(userName));
        articleDAO.addArticle(article);
    }

    @Override
    @Transactional
    public Article getArticleById(long id) {
        return articleDAO.getArticleById(id);
    }
}
