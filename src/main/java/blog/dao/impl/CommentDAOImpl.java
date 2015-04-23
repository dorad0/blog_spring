package blog.dao.impl;

import blog.dao.CommentDAO;
import blog.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 19.12.2014.
 */
@Repository
public class CommentDAOImpl extends GenericHibernateDAOImpl<Comment, Long> implements CommentDAO {

    @Override
    public List<Comment> getArticleComments(Long articleId) {
        return getCurrentSession().createQuery("FROM Comment WHERE article_id = " + articleId + " ORDER BY publicationDate ASC").list();
    }

}
