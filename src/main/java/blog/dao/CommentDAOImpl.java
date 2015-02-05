package blog.dao;


import blog.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 19.12.2014.
 */
public class CommentDAOImpl extends AbstractHibernateDao<Comment> implements CommentDAO {

}
