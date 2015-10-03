package blog.dao.impl;

import blog.annotation.ExceptionTranslation;
import blog.dao.ArticleDAO;
import blog.entity.Article;
import blog.entity.Comment;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Repository(value = "ArticleDAOImpl")
public class ArticleDAOImpl extends GenericHibernateDAOImpl<Article, Long> implements ArticleDAO {

    public static final int FIRST_DAY_OF_MONTH = 1;

    @ExceptionTranslation
    @Override
    public Set<Comment> getComments(Long id) {
        Article article = (Article) getCurrentSession().load(Article.class, id);
        Hibernate.initialize(article.getComments());

        return article.getComments();
    }

    @ExceptionTranslation
    @Override
    public List<LocalDate> getDates() {
        List<LocalDate> dates = new ArrayList<>();
        List<Object[]> list = getCurrentSession()
                .createSQLQuery("SELECT DISTINCT YEAR(publication_date) AS y, MONTH(publication_date) AS m FROM articles")
                .list();

        dates
                .addAll(
                        list.stream()
                                .map(mas -> LocalDate.of((Integer) mas[0], (Integer) mas[1], FIRST_DAY_OF_MONTH))
                                .collect(Collectors.toList())
                );

        return dates;
    }

    @ExceptionTranslation
    @Override
    public List<Article> findByMonthAndYear(LocalDate date) {
        return getCurrentSession()
                .createQuery("FROM Article WHERE YEAR(publicationDate) = :year AND MONTH(publicationDate) = :month")
                .setInteger("year", date.getYear())
                .setInteger("month", date.getMonthValue())
                .list();
    }

    @ExceptionTranslation
    @Override
    public List<Article> findAll() {
        return getCurrentSession().createCriteria(Article.class).addOrder(Order.desc("publicationDate")).list();
    }

    @ExceptionTranslation
    @Override
    public List<Article> findAll(int firstResult, int maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(Article.class);
        criteria.addOrder(Order.desc("publicationDate"));
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);

        return criteria.list();
    }

    @ExceptionTranslation
    @Override
    public Article getInitializedArticleById(Long id) {
        Article article = (Article) getCurrentSession().load(Article.class, id);
        Hibernate.initialize(article.getComments());

        return article;
    }

    @ExceptionTranslation
    @Override
    public Long getCount(LocalDate date) {
        return ((BigInteger) getCurrentSession()
                .createSQLQuery("SELECT COUNT(*) FROM articles WHERE YEAR(publication_date) = :year AND MONTH(publication_date) = :month")
                .setInteger("year", date.getYear())
                .setInteger("month", date.getMonthValue())
                .uniqueResult())
                .longValue();
    }

    @ExceptionTranslation
    @Override
    public Long getCount(int year, int month) {
        return ((BigInteger) getCurrentSession()
                .createSQLQuery("SELECT COUNT(*) FROM articles WHERE YEAR(publication_date) = :year AND MONTH(publication_date) = :month")
                .setInteger("year", year)
                .setInteger("month", month)
                .uniqueResult())
                .longValue();
    }

    @ExceptionTranslation
    @Override
    public List<Article> findAll(int firstResult, int maxResults, LocalDate date) {
        Query query = getCurrentSession()
                .createQuery("FROM Article WHERE YEAR(publicationDate) = :year AND MONTH(publicationDate) = :month ORDER BY publicationDate DESC")
                .setInteger("year", date.getYear())
                .setInteger("month", date.getMonthValue());

        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        List<Article> list = query.list();

        return list;
    }

    @ExceptionTranslation
    @Override
    public List<Article> findAll(int firstResult, int maxResults, int year, int month) {
        Query query = getCurrentSession()
                .createQuery("FROM Article WHERE YEAR(publicationDate) = :year AND MONTH(publicationDate) = :month ORDER BY publicationDate DESC")
                .setInteger("year", year)
                .setInteger("month", month);

        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        List<Article> list = query.list();

        return list;
    }

}
