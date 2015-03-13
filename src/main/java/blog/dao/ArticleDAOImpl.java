package blog.dao;

import blog.entity.Article;
import blog.entity.Comment;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by user on 15.12.2014.
 */

/*Spring takes care about transactions*/
@Repository(value = "ArticleDAOImpl")
public class ArticleDAOImpl extends GenericHibernateDAOImpl<Article> implements ArticleDAO {

    @Override
    public Set<Comment> getComments(long id) {
        Article article = (Article) getCurrentSession().load(Article.class, id);
        Hibernate.initialize(article.getComments());
        return article.getComments();
    }

    @Override
    public List<Calendar> getDates() {
        List<Calendar> calendars = new ArrayList<>();
        List<Object[]> list = getCurrentSession().createSQLQuery("SELECT DISTINCT YEAR(publicationDate) AS y, MONTH(publicationDate) AS m FROM Article").list();
        for (Object[] mas : list) {
            calendars.add(new GregorianCalendar((Integer) mas[0], (Integer) mas[1], 1));
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
    public List<Article> getEntityGroup(int fIndex, int groupSize) {
        Criteria criteria = getCurrentSession().createCriteria(Article.class);
        criteria.addOrder(Order.desc("publicationDate"));
        criteria.setFirstResult(fIndex);
        criteria.setMaxResults(groupSize);
        return criteria.list();
    }

    @Override
    public void deleteById(long id) {
//        Article article = (Article) getCurrentSession().load(Article.class, id);
//        getCurrentSession().delete(article);
        getCurrentSession().createQuery("DELETE FROM article WHERE id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public Article saveAndGet(Article article) {
        getCurrentSession().save(article);
        return article;
    }

    @Override
    public Article getInitializedArticleById(long id) {
        Article article = (Article) getCurrentSession().load(Article.class, id);
        Hibernate.initialize(article.getComments());
        return article;
    }
}
