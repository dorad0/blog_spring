package blog.service.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.ArticleDAO;
import blog.dao.UserDAO;
import blog.entity.Article;
import blog.entity.Comment;
import blog.service.ArticleService;
import blog.service.exception.ServiceException;
import blog.service.forms.ArticleForm;
import blog.service.pagination.ArticleArchivePagination;
import blog.service.pagination.ArticlePagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ArticleServiceImpl extends GenericServiceImpl<Long, Article, ArticleDAO> implements ArticleService {

    @Qualifier("UserDAOImpl")
    @Autowired
    private UserDAO userDAO;

    @Qualifier("articlePaginationImpl")
    @Autowired
    private ArticlePagination pagination;

    @Autowired
    private ArticleArchivePagination archivePagination;


    @Override
    @Autowired
    protected void setDao(@Qualifier("ArticleDAOImpl") ArticleDAO dao) {
        super.setDao(dao);
    }

    private blog.entity.User findUserByName(String userName) {
        return userDAO.findByName(userName);
    }

    @ExceptionTranslation
    @Override
    public Set<Comment> getComments(Long id) {
        return dao.getComments(id);
    }

    @ExceptionTranslation
    @Override
    public List<Calendar> getDates() {
        return dao.getDates();
    }

    @ExceptionTranslation
    @Override
    public List<Article> findByMonthAndYear(Calendar date) {
        return dao.findByMonthAndYear(date);
    }

    @ExceptionTranslation
    @Override
    public void save(Article article, String userName) {
        article.setUser(findUserByName(userName));
        article.setPublicationDate(new GregorianCalendar());
        save(article);
    }

    @ExceptionTranslation
    @Override
    public void save(Article article, User user) {
        article.setUser(findUserByName(user.getUsername()));
        article.setPublicationDate(new GregorianCalendar());
        save(article);
    }

    @ExceptionTranslation
    @Override
    public Article save(ArticleForm form, User user) {
        Article article = new Article(form.getTitle(), form.getText(), new GregorianCalendar(), findUserByName(user.getUsername()));
        save(article);

        return article;
    }

    @ExceptionTranslation
    @Override
    public Article getInitializedArticleById(Long id) {
        return dao.getInitializedArticleById(id);
    }

    @ExceptionTranslation
    @Override
    public Long getCount(Calendar date) {
        return dao.getCount(date);
    }

    @ExceptionTranslation
    @Override
    public List<Article> findAll(int firstResult, int maxResults, Calendar date) {
        return dao.findAll(firstResult, maxResults, date);
    }

    @ExceptionTranslation
    @Override
    public ArticlePagination getPagination() {
        return (ArticlePagination) pagination;
    }

    @ExceptionTranslation
    @Override
    public ArticleArchivePagination getArchivePagination() {
        return archivePagination;
    }

}
