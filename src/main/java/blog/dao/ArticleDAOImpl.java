package blog.dao;

import blog.entity.Article;
import blog.entity.Comment;
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
}
