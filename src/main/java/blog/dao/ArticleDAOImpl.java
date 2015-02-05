package blog.dao;

import blog.entity.Article;
import blog.entity.Comment;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 15.12.2014.
 */

/*Spring takes care about transactions*/
@Repository
public class ArticleDAOImpl extends AbstractHibernateDao<Article> implements ArticleDAO {

    @Override
    public Set<Comment> getComments(long id) {
        Article article = (Article) getCurrentSession().load(Article.class, id);
        return article.getComments();
    }
}
