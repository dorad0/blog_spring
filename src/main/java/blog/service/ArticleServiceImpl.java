package blog.service;

import blog.dao.ArticleDAO;
import blog.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 20.01.2015.
 */
@Service
public class ArticleServiceImpl {

    @Autowired
    private ArticleDAO dao;

    @Transactional
    public List<Article> getArticles() {
        return dao.getAllArticles();
    }
}
