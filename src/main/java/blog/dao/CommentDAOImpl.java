package blog.dao;


import blog.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 19.12.2014.
 */
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addComment(Comment comment) {
//        Session session = null;
        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
            Session session = sessionFactory.getCurrentSession();
            session.save(comment);
//            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        } /*finally {
            if (session != null && session.isOpen()) {
                session.close();
            }*/
//        }
    }

    @Override
    public void deleteComment(Comment comment) {
//        Session session = null;
        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
            Session session = sessionFactory.getCurrentSession();
            session.delete(comment);
//            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        } /*finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }*/
    }
}
