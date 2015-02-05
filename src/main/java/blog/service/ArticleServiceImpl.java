package blog.service;

import blog.dao.ArticleDAO;
import blog.dao.UserDAO;
import blog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 20.01.2015.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public Article getArticleById(long id) {
        return articleDAO.findById(id);
    }


//    @Transactional
//    public List<WebArticle> getArticles() {
//        List<Article> articles = articleDAO.getAllArticles();
//        List<WebArticle> webArticles = new ArrayList<>();
//        for(Article a : articles) {
//            webArticles.add(new WebArticle(a));
//        }
//        return webArticles;
//    }

//    @Transactional
//    public ArticlePage getArticlePage(int page) {
//        ArticlePaginator paginator = new ArticlePaginator(10);
//        return paginator.getPage(page);
//    }

//    @Override
//    @Transactional
//    public List<WebArticle> getArticlesByPage(long currentPage, long pageSize) {
//        List<Article> articles = articleDAO.getArticleGroup(currentPage, pageSize);
//        List<WebArticle> webArticles = new ArrayList<>();
//        for(Article a : articles) {
//            webArticles.add(new WebArticle(a));
//        }
//        return webArticles;
//    }



//    @Override
//    @Transactional
//    public long getArticleCount() {
//        return articleDAO.getArticleCount();
//    }
//
//    @Override
//    @Transactional
//    public void saveArticle(Article article, String userName) {
//        article.setPublicationDate(GregorianCalendar.getInstance());
//        article.setUser(userDAO.findByName(userName));
//        articleDAO.addArticle(article);
//    }
//
//    @Override
//    @Transactional
//    public Article getArticleById(long id) {
//        return articleDAO.getArticleById(id);
//    }

}
