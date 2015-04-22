package blog.dao.impl;

import blog.dao.ArticleDAO;
import blog.entity.Article;
import blog.entity.Comment;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by user on 15.12.2014.
 */
@Repository(value = "ArticleDAOImpl")
public class ArticleDAOImpl extends GenericHibernateDAOImpl<Article> implements ArticleDAO {

    public static final int FIRST_DAY_OF_MONTH = 1;

    @Override
    public Set<Comment> getComments(Long id) {
        Article article = (Article) getCurrentSession().load(Article.class, id);
        Hibernate.initialize(article.getComments());

        return article.getComments();
    }

    @Override
    public List<Calendar> getDates() {
        List<Calendar> calendars = new ArrayList<>();
        List<Object[]> list = getCurrentSession().createSQLQuery("SELECT DISTINCT YEAR(publicationDate) AS y, MONTH(publicationDate) AS m FROM Article").list();

        for (Object[] mas : list) {
            calendars.add(new GregorianCalendar((Integer) mas[0], (Integer) mas[1] - 1, FIRST_DAY_OF_MONTH));
        }

        return calendars;
    }

    @Override
    public List<Article> findByMonthAndYear(Calendar date) {
        return getCurrentSession().createQuery("FROM article WHERE YEAR(publicationDate) = :year AND MONTH(publicationDate) = :month").setInteger("year", date.get(Calendar.YEAR)).setInteger("month", date.get(Calendar.MONTH)).list();
    }

    @Override
    public List<Article> findAll() {
        return getCurrentSession().createCriteria(Article.class).addOrder(Order.desc("publicationdate")).list();
    }

    @Override
    public List<Article> findAll(int firstResult, int maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(Article.class);
        criteria.addOrder(Order.desc("publicationDate"));
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);

        return criteria.list();
    }

    @Override
    public Article getInitializedArticleById(Long id) {
        Article article = (Article) getCurrentSession().load(Article.class, id);
        Hibernate.initialize(article.getComments());

        return article;
    }

    @Override
    public Long getCount(Calendar date) {
        return ((BigInteger) getCurrentSession().createSQLQuery("SELECT COUNT(*) FROM article WHERE YEAR(publicationDate) = :year AND MONTH(publicationDate) = :month")
                .setInteger("year", date.get(Calendar.YEAR)).setInteger("month", date.get(Calendar.MONTH)).uniqueResult()).longValue();
    }

    @Override
    public List<Article> findAll(int firstResult, int maxResults, Calendar date) {
        Query query = getCurrentSession()
                .createQuery("FROM Article WHERE YEAR(publicationDate) = :year AND MONTH(publicationDate) = :month ORDER BY publicationDate DESC")
                .setInteger("year", date.get(Calendar.YEAR)).setInteger("month", date.get(Calendar.MONTH));
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        List<Article> list = query.list();

        return list;
    }

}
