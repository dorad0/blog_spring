package blog.dao.impl;

import blog.dao.CommentDAO;
import blog.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 19.12.2014.
 */
@Repository
public class CommentDAOImpl extends GenericHibernateDAOImpl<Comment> implements CommentDAO {

    @Override
    public List<Comment> getArticleComments(Long id) {
        return getCurrentSession().createQuery("FROM Comment WHERE article_id = " + id + " ORDER BY publicationDate ASC").list();
    }

    @Override
    public void deleteCommentById(Long id) {
        getCurrentSession().createSQLQuery("DELETE FROM Comment  WHERE id = :id ").setParameter("id", id).executeUpdate();
    }

}
