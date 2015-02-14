package blog.service.article;

import blog.dao.ArticleDAO;
import blog.dao.UserDAO;
import blog.entity.Article;
import blog.entity.Comment;
import blog.service.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 05.02.2015.
 */
@Service
@Transactional
public class ArticleManagerImpl extends GenericManagerImpl<Article, ArticleDAO> implements ArticleManager {

    @Qualifier("UserDAOImpl")
    @Autowired
    private UserDAO userDAO;

    @Override
    @Autowired
    protected void setDao(@Qualifier("ArticleDAOImpl") ArticleDAO dao) {
        super.setDao(dao);
    }

    @Override
    public Set<Comment> getComments(long id) {
        return dao.getComments(id);
    }

    @Override
    public List<Calendar> getDates() {
        return dao.getDates();
    }

    @Override
    public void save(Article article, String userName) {
        article.setUser(userDAO.findByName(userName));
        article.setPublicationDate(new GregorianCalendar());
        save(article);
    }

    @Override
    public void save(Article article, User user) {
        article.setUser(userDAO.findByName(user.getUsername()));
        article.setPublicationDate(new GregorianCalendar());
        save(article);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
