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
import blog.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Autowired
    private Converter converter;

    @Override
    @Autowired
    protected void setGenericDAO(@Qualifier("ArticleDAOImpl") ArticleDAO genericDAO) {
        super.setGenericDAO(genericDAO);
    }

    private blog.entity.User findUserByName(String userName) {
        return userDAO.findByName(userName);
    }

    @ExceptionTranslation
    @Override
    public Set<Comment> getComments(Long id) {
        return genericDAO.getComments(id);
    }

    @ExceptionTranslation
    @Override
    public List<LocalDate> getDates() {
        return genericDAO.getDates();
    }

    @ExceptionTranslation
    @Override
    public List<Article> findByMonthAndYear(LocalDate date) {
        return genericDAO.findByMonthAndYear(date);
    }

    @ExceptionTranslation
//    @Override
    public void save(Article article, String userName) {
        article.setUser(findUserByName(userName));
        article.setPublicationDate(LocalDateTime.now());
        save(article);
    }

    @ExceptionTranslation
//    @Override
    public void save(Article article, User user) {
        article.setUser(findUserByName(user.getUsername()));
        article.setPublicationDate(LocalDateTime.now());
        save(article);
    }

    @ExceptionTranslation
//    @Override
    public Article save(ArticleForm form, User user) {
        Article article = new Article(form.getTitle(), form.getText(), LocalDateTime.now(), findUserByName(user.getUsername()));
        save(article);

        return article;

    }

    @ExceptionTranslation
    @Override
    public Long save(ArticleForm articleForm) throws ServiceException {
        Article article = converter.convertArticleFormToArticle(articleForm);

        return save(article);
    }

    @Override
    public Article saveArticleFromForm(ArticleForm articleForm) throws ServiceException {
        Article article = converter.convertArticleFormToArticle(articleForm);
        Long articleId = save(article);

        return genericDAO.findById(articleId);
    }

    @ExceptionTranslation
    @Override
    public Article getInitializedArticleById(Long id) {
        return genericDAO.getInitializedArticleById(id);
    }

    @ExceptionTranslation
    @Override
    public Long getCount(LocalDate date) {
        return genericDAO.getCount(date);
    }

    @ExceptionTranslation
    @Override
    public List<Article> findAll(int firstResult, int maxResults, LocalDate date) {
        return genericDAO.findAll(firstResult, maxResults, date);
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

    @ExceptionTranslation
    @Override
    public void delete(Long aLong) {

        super.delete(aLong);
    }
}
